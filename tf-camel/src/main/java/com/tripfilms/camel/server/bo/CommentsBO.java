package com.tripfilms.camel.server.bo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tripfilms.camel.server.be.Comment;
import com.tripfilms.camel.server.be.Video;
import com.tripfilms.camel.server.dao.IVideoDAO;

public class CommentsBO implements ICommentsBO{
	
	@Autowired
	private INotifyUserBO mNotifyUserServiceBO;
	
	@Autowired
	private IVideoDAO mVideoDAO;
	
	static final Logger logger = LoggerFactory.getLogger(CommentsBO.class);

	public String  getComments(List<Video> pVideos) {
		int oNewComments = 0;
		
		for (Video oVideoBE : pVideos) {
			oNewComments += isNewVideo(oVideoBE)?oVideoBE.getComments().size():countComments(oVideoBE);
		}		
		return mNotifyUserServiceBO.sendResultMessage(oNewComments);
	}
	
	private boolean isNewVideo(Video pVideo){
		if(!mVideoDAO.videoExists(pVideo.getId())){
			logger.debug("new video add to the list");
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
		List <Comment> oSavedComments = mVideoDAO.fetchCommentsByVideoId(pVideo.getId());
		for (Comment oComment : oCurrentComments) {
			if(!mapVideosContainsComment(oSavedComments,oComment)){
				logger.debug("new comment on the video");
				mVideoDAO.saveComment(pVideo.getId(), oComment);
				oNewComments++;
			}
		}	
		return oNewComments;
	}
	
	private boolean mapVideosContainsComment(List <Comment> pListVideoComments,Comment pCommentBE ){
		for (Comment oVideoOldComment : pListVideoComments) {
			if(oVideoOldComment.getId().equals(pCommentBE.getId())){return true;}
		}
		return false;
	}
	
}
