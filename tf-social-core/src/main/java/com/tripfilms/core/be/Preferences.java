package com.tripfilms.core.be;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Preferences {  

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long mId;
	
	@Column(name="post_on_fb_timeline")
    private boolean mPostOnFBTimeline;
    
	@Column(name="send_email")
    private boolean mSendEmail;
	
	@OneToOne
	@JoinColumn(name="user_fkey")
	private UserConnection mUserConnection;

	public Long getId() {
		return mId;
	}

	public void setId(Long pId) {
		mId = pId;
	}

	public boolean isPostOnFBTimeline() {
		return mPostOnFBTimeline;
	}

	public void setPostOnFBTimeline(boolean pPostOnFBTimeline) {
		mPostOnFBTimeline = pPostOnFBTimeline;
	}

	public boolean isSendEmail() {
		return mSendEmail;
	}

	public void setSendEmail(boolean pSendEmail) {
		mSendEmail = pSendEmail;
	}

	public UserConnection getUserConnection() {
		return mUserConnection;
	}

	public void setUserConnection(UserConnection pUserConnection) {
		mUserConnection = pUserConnection;
	}
	  
}  
