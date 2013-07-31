package com.tripfilms.camel.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tripfilms.camel.server.be.Comment;
import com.tripfilms.camel.server.be.Video;

public class CamelClient {

	static final Logger logger = LoggerFactory.getLogger(CamelClient.class);
	
	public static void main(final String[] args) throws Exception {
		
		CamelClient oClientTF = new CamelClient();
	 
	    ApplicationContext context = new ClassPathXmlApplicationContext("camel-client.xml");
	 
	    ProducerTemplate camelTemplate = context.getBean("camelTemplate", ProducerTemplate.class);
	   
	    logger.info("New videos with new comments ");
	    String response = (String)camelTemplate.sendBody("jms:queue:commentsQueue", ExchangePattern.InOut,oClientTF.getNewVideosList());
	    logger.info("... the result is: " + response);
	    
	    logger.info("Same videos with the same comments ");
	    response = (String)camelTemplate.sendBody("jms:queue:commentsQueue", ExchangePattern.InOut,oClientTF.getNewVideosList());
	    logger.info("... the result is: " + response);
	    
	    logger.info("Same videos with new comments ");
	    response = (String)camelTemplate.sendBody("jms:queue:commentsQueue", ExchangePattern.InOut,oClientTF.getOldVideosListWithNewComments());
	    logger.info("... the result is: " + response);
	 
	 
	    System.exit(0);
	}
	
	public List <Video> getNewVideosList(){
		List <Video> videos = new ArrayList<Video>();
		videos.add(new Video(1L,getCommentsList()));
		videos.add(new Video(2L,getCommentsList()));
		videos.add(new Video(3L,getCommentsList()));
		return videos;
	}
	
	public List <Video> getOldVideosListWithNewComments(){
		List <Video> videos = new ArrayList<Video>();
		videos.add(new Video(1L,getNewCommentsList()));
		videos.add(new Video(3L,getNewCommentsList()));
		return videos;
	}
	
	private List<Comment> getCommentsList(){
		List<Comment> oCommentBEs = new ArrayList<Comment>();
		oCommentBEs.add(new Comment(1L,"cool"));
		oCommentBEs.add(new Comment(2L,"nice"));
		oCommentBEs.add(new Comment(3L,"awesome"));
		return oCommentBEs;
		
	}
	private List<Comment> getNewCommentsList(){
		List<Comment> oCommentBEs = new ArrayList<Comment>();
		oCommentBEs.add(new Comment(4L,"good"));
		oCommentBEs.add(new Comment(5L,"ok"));
		oCommentBEs.add(new Comment(6L,"fantastic"));
		return oCommentBEs;
	}
	
	
	
}
