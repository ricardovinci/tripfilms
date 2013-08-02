package com.tripfilms.camel.server.facebook.be;

import java.io.Serializable;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class FBCommentData implements Serializable {

	private static final long serialVersionUID = -2816956687802039569L;

	@SerializedName("id")
	private String mId;
	
	@SerializedName("message")
	private String mComment;
	
	@SerializedName("created_time")
	private Date mCreatedTime;
	
	public String getId() {
		return mId;
	}

	public void setId(String pId) {
		mId = pId;
	}

	public String getComment() {
		return mComment;
	}

	public void setComment(String pComment) {
		mComment = pComment;
	}

	public Date getCreatedTime() {
		return mCreatedTime;
	}

	public void setCreatedTime(Date pCreatedTime) {
		mCreatedTime = pCreatedTime;
	}
}
