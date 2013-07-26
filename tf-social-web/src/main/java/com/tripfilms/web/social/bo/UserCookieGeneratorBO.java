package com.tripfilms.web.social.bo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.CookieGenerator;

final class UserCookieGeneratorBO {

	private final CookieGenerator mUserCookieGenerator = new CookieGenerator();

	public UserCookieGeneratorBO() {
		mUserCookieGenerator.setCookieName("tf_social_web_user");
	}

	public void addCookie(String pUserId, HttpServletResponse pResponse) {
		mUserCookieGenerator.addCookie(pResponse, pUserId);
	}
	
	public void removeCookie(HttpServletResponse pResponse) {
		mUserCookieGenerator.addCookie(pResponse, "");
	}
	
	public String readCookieValue(HttpServletRequest pRequest) {
		Cookie[] oCookies = pRequest.getCookies();
		if (oCookies == null) {
			return null;
		}
		for (Cookie oCookie : oCookies) {
			if (oCookie.getName().equals(mUserCookieGenerator.getCookieName())) {
				return oCookie.getValue();
			}
		}
		return null;
	}

}
