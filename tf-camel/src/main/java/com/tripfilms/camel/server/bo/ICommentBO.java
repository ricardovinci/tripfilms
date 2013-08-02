package com.tripfilms.camel.server.bo;

import java.util.List;

import com.tripfilms.camel.server.be.Video;

public interface ICommentBO {
	public int checkNewComments(List<Video> videos);
}
