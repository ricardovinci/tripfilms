package com.tripfilms.core.be;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserConnection {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long mId;
	
	@Column(name="userId")
    private String mUserId;
	
	@Column(name="providerId")
    private String mProviderId;
	
	@Column(name="providerUserId")
    private String mProviderUserId;
	
	@Column(name="rank")
    private int mRank;
	
	@Column(name="displayName")
    private String mDisplayName;
	
	@Column(name="profileUrl")
    private String mProfileUrl;
	
	@Column(name="imageUrl")
    private String mImageUrl;
	
	@Column(name="accessToken")
    private String mAccessToken;
	
	@Column(name="secret")
    private String mSecret;

	@Column(name="refreshToken")
    private String mRefreshToken;

	@Column(name="expireTime")
	private Long mExpireTime;

	public Long getId() {
		return mId;
	}

	public void setId(Long pId) {
		mId = pId;
	}

	public String getUserId() {
		return mUserId;
	}

	public void setUserId(String pUserId) {
		mUserId = pUserId;
	}

	public String getProviderId() {
		return mProviderId;
	}

	public void setProviderId(String pProviderId) {
		mProviderId = pProviderId;
	}

	public String getProviderUserId() {
		return mProviderUserId;
	}

	public void setProviderUserId(String pProviderUserId) {
		mProviderUserId = pProviderUserId;
	}

	public int getRank() {
		return mRank;
	}

	public void setRank(int pRank) {
		mRank = pRank;
	}

	public String getDisplayName() {
		return mDisplayName;
	}

	public void setDisplayName(String pDisplayName) {
		mDisplayName = pDisplayName;
	}

	public String getProfileUrl() {
		return mProfileUrl;
	}

	public void setProfileUrl(String pProfileUrl) {
		mProfileUrl = pProfileUrl;
	}

	public String getImageUrl() {
		return mImageUrl;
	}

	public void setImageUrl(String pImageUrl) {
		mImageUrl = pImageUrl;
	}

	public String getAccessToken() {
		return mAccessToken;
	}

	public void setAccessToken(String pAccessToken) {
		mAccessToken = pAccessToken;
	}

	public String getSecret() {
		return mSecret;
	}

	public void setSecret(String pSecret) {
		mSecret = pSecret;
	}

	public String getRefreshToken() {
		return mRefreshToken;
	}

	public void setRefreshToken(String pRefreshToken) {
		mRefreshToken = pRefreshToken;
	}

	public Long getExpireTime() {
		return mExpireTime;
	}

	public void setExpireTime(Long pExpireTime) {
		mExpireTime = pExpireTime;
	}

    

}
