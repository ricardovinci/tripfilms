package com.tripfilms.web.social.bo;

import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;

import com.tripfilms.web.be.User;

public final class SimpleSignInAdapterBO implements SignInAdapter {

	private final UserCookieGeneratorBO mUserCookieGenerator = new UserCookieGeneratorBO();
	
	public String signIn(String pUserId, Connection<?> pConnection, NativeWebRequest pRequest) {
		SecurityContextBO.setCurrentUser(new User(pUserId));
		mUserCookieGenerator.addCookie(pUserId, pRequest.getNativeResponse(HttpServletResponse.class));
		return null;
	}

}
