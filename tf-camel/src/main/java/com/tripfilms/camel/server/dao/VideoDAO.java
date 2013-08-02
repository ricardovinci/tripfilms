package com.tripfilms.camel.server.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tripfilms.camel.server.be.Comment;
import com.tripfilms.camel.server.be.Video;

public class VideoDAO implements IVideoDAO {
	
	private static Map<String, Video> mVideoMap = new HashMap<String, Video>();

	public List <Comment> fetchCommentsByVideoId(String pId) {
		return mVideoMap.get(pId).getComments();
	}
	
	public void saveLastCommentDate(String pId, Date pLastCommentDate) {
		mVideoMap.get(pId).setLastCommentDate(pLastCommentDate);
	}

	public void save(Video pVideo) {
		mVideoMap.put(pVideo.getId(), pVideo);		
	}

	public boolean videoExists(String pId) {		
		return mVideoMap.containsKey(pId);
	}
	
	public Date fecthLastCommentDateByVideoId(String pId){
		return mVideoMap.get(pId).getLastCommentDate();
	}

	public void saveComment(String pVideoId, Comment pComment) {
		mVideoMap.get(pVideoId).getComments().add(pComment);
	}

}
