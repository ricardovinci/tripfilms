package com.tripfilms.camel.server.start;

import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;

public class ScheduledComment {

	static final Logger mLogger = LoggerFactory.getLogger(ScheduledComment.class);

	@Scheduled(fixedDelay = 5000)
	public void checkComments() {

		ApplicationContext oContext = new ClassPathXmlApplicationContext("camel-schedule.xml");

		ProducerTemplate oCamelTemplate = oContext.getBean("camelTemplate",ProducerTemplate.class);

		mLogger.info("Checking new comments ");
		oCamelTemplate.sendBody("jms:queue:startQueue", ExchangePattern.InOnly);

	}
}
