package com.tripfilms.camel.server.facebook.be;

import java.io.Serializable;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class FBResponse implements Serializable {
	
	private static final long serialVersionUID = -2468439156142881659L;
	
	//@SerializedName("http://developers.facebook.com/docs/reference/plugins/comments")
	private Map<String, String> mFacebookCommentsResponse;

	public Map<String, String> getFacebookCommentsResponse() {
		return mFacebookCommentsResponse;
	}

	public void setFacebookCommentsResponse(
			Map<String, String> pFacebookCommentsResponse) {
		mFacebookCommentsResponse = pFacebookCommentsResponse;
	}


	
//	public FBCommentsResponse getFacebookCommentsResponse() {
//		return mFacebookCommentsResponse;
//	}
//
//	public void setFacebookCommentsResponse(
//			FBCommentsResponse pFacebookCommentsResponse) {
//		mFacebookCommentsResponse = pFacebookCommentsResponse;
//	}

	
}
