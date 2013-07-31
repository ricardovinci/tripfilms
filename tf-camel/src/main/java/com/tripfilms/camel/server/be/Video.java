package com.tripfilms.camel.server.be;

import java.io.Serializable;
import java.util.List;

public class Video implements Serializable {

	private static final long serialVersionUID = -1380048544755003141L;
	
	private Long mId;
	
	private List <Comment> mComments;
	
	public Video(){}
	
	public Video(Long pId,List <Comment> pComments){
		this.mId = pId;
		this.mComments = pComments;
	}

	public Long getId() {
		return mId;
	}

	public void setId(Long pId) {
		mId = pId;
	}

	public List<Comment> getComments() {
		return mComments;
	}

	public void setComments(List<Comment> pComments) {
		mComments = pComments;
	}
	
	

}
