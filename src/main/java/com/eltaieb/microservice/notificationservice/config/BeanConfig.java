package com.eltaieb.microservice.notificationservice.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class BeanConfig {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	@Primary
	public RedisProperties redisProperties() {
		return new RedisProperties();
	}
	

	@Bean
	public List binding()
	{
 		return Arrays.asList(emailQueue(), smsQueue(), notificationExchange(),
				BindingBuilder.bind(emailQueue()).to(notificationExchange()).with(ServiceConstant.NOTIFICATION_MESSAGE_SMS_QUEUE_BINDING_KEY),
				BindingBuilder.bind(smsQueue()).to(notificationExchange()).with(ServiceConstant.NOTIFICATION_MESSAGE_SMS_QUEUE_BINDING_KEY),
				BindingBuilder.bind(messageHistoryQueue()).to(messagesHistoryExchange()).withQueueName());
	}

	@Bean
	public Queue emailQueue() {
		return new Queue(ServiceConstant.NOTIFICATION_MESSAGE_EMAIL_QUEUE_NAME, true, false, false);
	}
	
	@Bean
	public Queue smsQueue() {
		return new Queue(ServiceConstant.NOTIFICATION_MESSAGE_SMS_QUEUE_NAME, true, false, false);

	}

	@Bean
	public DirectExchange notificationExchange() {
		return new DirectExchange(ServiceConstant.NOTIFICATION_MESSAGE_EXCHANGE_NAME, true, false);
	}
	
	
	
	@Bean
	public Queue messageHistoryQueue() {
		return new Queue(ServiceConstant.NOTIFICATION_MESSAGE_HISTORY_QUEUE_NAME, true, false, false);
	}

	@Bean
	public DirectExchange messagesHistoryExchange() {
		return new DirectExchange(ServiceConstant.NOTIFICATION_MESSAGE_HISTORY_EXCHANGE_NAME, true, false);
	}
	

	 
}
