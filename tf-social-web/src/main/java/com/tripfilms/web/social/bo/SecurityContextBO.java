package com.tripfilms.web.social.bo;

import com.tripfilms.web.be.User;

public final class SecurityContextBO {

	private static final ThreadLocal<User> mCurrentUser = new ThreadLocal<User>();

	public static User getCurrentUser() {
		User oUser = mCurrentUser.get();
		if (oUser == null) {
			throw new IllegalStateException("No user is currently signed in");
		}
		return oUser;
	}

	public static void setCurrentUser(User pUser) {
		mCurrentUser.set(pUser);
	}

	public static boolean userSignedIn() {
		return mCurrentUser.get() != null;
	}

	public static void remove() {
		mCurrentUser.remove();
	}

}
