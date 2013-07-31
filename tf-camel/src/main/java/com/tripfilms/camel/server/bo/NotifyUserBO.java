package com.tripfilms.camel.server.bo;


public class NotifyUserBO implements INotifyUserBO {

	public String sendResultMessage(int pNewComments) {
	 return "You have "+pNewComments+" new comments on your videos!";
	}

}
