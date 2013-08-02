package com.tripfilms.camel.server.facebook.be;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class FBCommentsResponse implements Serializable{

	private static final long serialVersionUID = 4147854685377061066L;
	
	@SerializedName("comments")
	FBComment mComments;

	public FBComment getComments() {
		return mComments;
	}

	public void setComments(FBComment pComments) {
		mComments = pComments;
	}
	
	
	
}
