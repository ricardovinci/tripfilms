package com.tripfilms.camel.server.be;

import java.io.Serializable;

public class Comment implements Serializable {

	private static final long serialVersionUID = -2816956687802039569L;

	private Long mId;

	private String mComment;

	public Comment() {}

	public Comment(Long pId, String pComment) {
		this.mId = pId;
		this.mComment = pComment;
	}

	public String getComment() {
		return mComment;
	}

	public void setComment(String pComment) {
		mComment = pComment;
	}

	public Long getId() {
		return mId;
	}

	public void setId(Long pId) {
		mId = pId;
	}

}
