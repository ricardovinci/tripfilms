package com.tripfilms.camel.server.be;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable, Comparable<Comment> {

	private static final long serialVersionUID = 5065481987843621082L;

	private String mId;

	private String message;
	
	private Date date;
	
	public String getId() {
		return mId;
	}

	public void setId(String pId) {
		mId = pId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String pMessage) {
		message = pMessage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date pDate) {
		date = pDate;
	}

	public int compareTo(Comment pComment) {
		return getDate().compareTo(pComment.getDate());
	}
}
