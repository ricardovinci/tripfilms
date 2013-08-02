package com.tripfilms.camel.server.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class NotificationBO implements INotificationBO {

	static final Logger logger = LoggerFactory.getLogger(NotificationBO.class);
	
	public void notify(int pNewComments) {
		logger.info("****** NotificationBO");
		logger.info("Total new comments "+pNewComments);
		
	 //return "You have "+pNewComments+" new comments on your videos!";
	}

}
