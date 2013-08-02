package com.tripfilms.camel.server.be;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Video implements Serializable{

	private static final long serialVersionUID = 5997375600563087239L;

	private String mId;
	
	private List<Comment> mComments;
	
	private Date mLastCommentDate;

	public String getId() {
		return mId;
	}

	public void setId(String pId) {
		mId = pId;
	}

	public List<Comment> getComments() {
		return mComments;
	}

	public void setComments(List<Comment> pComments) {
		mComments = pComments;
	}

	public Date getLastCommentDate() {
		return mLastCommentDate;
	}

	public void setLastCommentDate(Date pLastCommentDate) {
		mLastCommentDate = pLastCommentDate;
	}
	
	
}
