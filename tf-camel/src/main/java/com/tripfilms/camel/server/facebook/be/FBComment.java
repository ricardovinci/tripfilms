package com.tripfilms.camel.server.facebook.be;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
//https://graph.facebook.com/comments/?ids=http://developers.facebook.com/docs/reference/plugins/comments


import com.google.gson.annotations.SerializedName;

public class FBComment implements Serializable {

	private static final long serialVersionUID = -1380048544755003141L; 
	
	@SerializedName("data")
	private List <FBCommentData> mCommentsData;

	private Date mCreatedComment;
	
	public List<FBCommentData> getCommentsData() {
		return mCommentsData;
	}

	public void setCommentsData(List<FBCommentData> pCommentsData) {
		mCommentsData = pCommentsData;
	}

	public Date getCreatedComment() {
		return mCreatedComment;
	}

	public void setCreatedComment(Date pCreatedComment) {
		mCreatedComment = pCreatedComment;
	}

	
	

}
