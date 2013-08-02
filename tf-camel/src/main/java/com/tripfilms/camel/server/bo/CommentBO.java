package com.tripfilms.camel.server.bo;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tripfilms.camel.server.be.Comment;
import com.tripfilms.camel.server.be.Video;
import com.tripfilms.camel.server.dao.IVideoDAO;

public class CommentBO implements ICommentBO{
	
	@Autowired
	private IVideoDAO mVideoDAO;
	
	static final Logger logger = LoggerFactory.getLogger(CommentBO.class);

	public int checkNewComments(List<Video> pVideos) {
		logger.info("********* CommentsBO");
		int oNewComments = 0;
		int oCount = 0;
		for (Video oVideo : pVideos) {
			Collections.sort(oVideo.getComments());
			
			oNewComments += isNewVideo(oVideo)?oVideo.getComments().size():countComments(oVideo);
			
			oCount = oCount==0?oNewComments:oCount-oNewComments;
			logger.info(oVideo.getId()+" got "+oCount+" new comments ");
		}		
		return oNewComments;
	}
	
	private boolean isNewVideo(Video pVideo){
		if(!mVideoDAO.videoExists(pVideo.getId())){
			pVideo.setLastCommentDate(pVideo.getComments().get(pVideo.getComments().size()-1).getDate());
			mVideoDAO.save(pVideo);
			return true;
		}
		logger.debug("video already in the list");
		return false;
	}
	
	private int countComments(Video pVideo){
		logger.debug("Counting comments..");
		int oNewComments=0;
		
		List <Comment> oCurrentComments = pVideo.getComments();
	
		for (Comment oComment : oCurrentComments) {
			if(!videoContainsComment(pVideo.getId(), oComment)){
				mVideoDAO.saveComment(pVideo.getId(), oComment);
				mVideoDAO.saveLastCommentDate(pVideo.getId(), oComment.getDate());
				oNewComments++;
			}
		}
		return oNewComments;
	}
	
	private boolean videoContainsComment(String pId, Comment pComment ){		
		if(pComment.getDate().after(mVideoDAO.fecthLastCommentDateByVideoId(pId))){
			return false;
		}
		return true;
	}
	
}
