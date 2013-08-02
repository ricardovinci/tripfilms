package com.tripfilms.camel.server.be;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable, Comparable<Comment> {

	private static final long serialVersionUID = 5065481987843621082L;

	private String mId;

	private String mMessage;
	
	private Date mDate;
	
	public String getId() {
		return mId;
	}

	public void setId(String pId) {
		mId = pId;
	}

	public String getMessage() {
		return mMessage;
	}

	public void setMessage(String pMessage) {
		mMessage = pMessage;
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date pDate) {
		mDate = pDate;
	}

	public int compareTo(Comment pComment) {
		return getDate().compareTo(pComment.getDate());
	}
}
