package com.tripfilms.camel.server.dao;

import java.util.List;

import com.tripfilms.camel.server.be.Comment;
import com.tripfilms.camel.server.be.Video;

public interface IVideoDAO {
	
	public List <Comment> fetchCommentsByVideoId(Long pId);
	
	public void save(Video pVideo);
	
	public boolean videoExists(Long pId);
	
	public void saveComment(Long pVideoId, Comment pComment);

}
