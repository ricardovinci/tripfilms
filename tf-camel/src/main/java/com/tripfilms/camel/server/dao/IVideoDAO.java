package com.tripfilms.camel.server.dao;

import java.util.Date;
import java.util.List;

import com.tripfilms.camel.server.be.Comment;
import com.tripfilms.camel.server.be.Video;

public interface IVideoDAO {
	
	public List <Comment> fetchCommentsByVideoId(String pId);
	
	public void saveLastCommentDate(String pId, Date pLastCommentDate);
	
	public void save(Video pVideo);
	
	public boolean videoExists(String pId);
	
	public Date fecthLastCommentDateByVideoId(String pId);
	
	public void saveComment(String pVideoId, Comment pComment);

}
