package com.tripfilms.camel.server.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tripfilms.camel.server.be.Comment;
import com.tripfilms.camel.server.be.Video;

public class VideoDAO implements IVideoDAO {
	
	private static Map<Long, Video> mVideoMap = new HashMap<Long, Video>();

	public List <Comment> fetchCommentsByVideoId(Long pId) {
		return mVideoMap.get(pId).getComments();
	}

	public void save(Video pVideo) {
		mVideoMap.put(pVideo.getId(), pVideo);		
	}

	public boolean videoExists(Long pId) {		
		return mVideoMap.containsKey(pId);
	}

	public void saveComment(Long pVideoId, Comment pComment) {
		mVideoMap.get(pVideoId).getComments().add(pComment);
	}

}
