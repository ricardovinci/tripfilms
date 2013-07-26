package com.tripfilms.web.social.bo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

public final class SimpleConnectionSignUpBO implements ConnectionSignUp {

	private final AtomicLong mUserIdSequence = new AtomicLong();
	
	public String execute(Connection<?> pConnection) {
		return Long.toString(mUserIdSequence.incrementAndGet());
	}

}
