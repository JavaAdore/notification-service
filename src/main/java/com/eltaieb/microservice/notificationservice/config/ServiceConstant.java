package com.eltaieb.microservice.notificationservice.config;

import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
@Service
public class ServiceConstant {

 
	


 
	public static final String DEFAULT_NOTIFICATION_LOCALE = "en";

	
	public static final String NOTIFICATION_MESSAGE_SMS_QUEUE_BINDING_KEY ="sms";
	
	public static final String NOTIFICATION_MESSAGE_EMAIL_QUEUE_BINDING_KEY ="email";
	
	public static final String NOTIFICATION_MESSAGE_SMS_QUEUE_NAME = "smsQueue";

	
	public static final String NOTIFICATION_MESSAGE_EMAIL_QUEUE_NAME = "emailQueue";

	
	public static final String NOTIFICATION_MESSAGE_EXCHANGE_NAME = "notification.exchange";

	
	public static final String NOTIFICATION_MESSAGE_HISTORY_QUEUE_NAME = "messagesHistoryQueue";
	
	public static final String NOTIFICATION_MESSAGE_HISTORY_EXCHANGE_NAME = "messagesHistory.exchange";

 
 
}
