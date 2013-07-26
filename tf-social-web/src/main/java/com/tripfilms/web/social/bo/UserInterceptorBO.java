package com.tripfilms.web.social.bo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;

import com.tripfilms.web.be.User;

public final class UserInterceptorBO extends HandlerInterceptorAdapter {

	private final UsersConnectionRepository mConnectionRepository;
	
	private final UserCookieGeneratorBO mUserCookieGenerator = new UserCookieGeneratorBO();

	public UserInterceptorBO(UsersConnectionRepository pConnectionRepository) {
		this.mConnectionRepository = pConnectionRepository;
	}
	
	public boolean preHandle(HttpServletRequest pRequest, HttpServletResponse pResponse, Object pHandler) throws Exception {
		rememberUser(pRequest, pResponse);
		handleSignOut(pRequest, pResponse);			
		if (SecurityContextBO.userSignedIn() || requestForSignIn(pRequest)) {
			return true;
		} else {
			return requireSignIn(pRequest, pResponse);
		}
	}
	
	public void afterCompletion(HttpServletRequest pRequest, HttpServletResponse pResponse, Object pHandler, Exception pEx) throws Exception {
		SecurityContextBO.remove();
	}

	private void rememberUser(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		String oUserId = mUserCookieGenerator.readCookieValue(pRequest);
		if (oUserId == null) {
			return;
		}
		if (!userNotFound(oUserId)) {
			mUserCookieGenerator.removeCookie(pResponse);
			return;
		}
		SecurityContextBO.setCurrentUser(new User(oUserId));
	}

	private void handleSignOut(HttpServletRequest pRequest, HttpServletResponse pResponse) {
		if (SecurityContextBO.userSignedIn() && pRequest.getServletPath().startsWith("/signout")) {
			mConnectionRepository.createConnectionRepository(SecurityContextBO.getCurrentUser().getId()).removeConnections("facebook");
			mUserCookieGenerator.removeCookie(pResponse);
			SecurityContextBO.remove();			
		}
	}
		
	private boolean requestForSignIn(HttpServletRequest pRequest) {
		return pRequest.getServletPath().startsWith("/signin");
	}
	
	private boolean requireSignIn(HttpServletRequest pRequest, HttpServletResponse pResponse) throws Exception {
		new RedirectView("/signin", true).render(null, pRequest, pResponse);
		return false;
	}

	private boolean userNotFound(String pUserId) {
		return mConnectionRepository.createConnectionRepository(pUserId).findPrimaryConnection(Facebook.class) != null;
	}
	
}
