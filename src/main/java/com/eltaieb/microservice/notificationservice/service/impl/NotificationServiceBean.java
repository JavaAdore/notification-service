package com.eltaieb.microservice.notificationservice.service.impl;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.stringtemplate.v4.ST;

import com.eltaieb.microservice.base.config.BaseServiceConstant;
import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.base.model.ErrorMessageCode;
import com.eltaieb.microservice.notificationservice.config.ServiceConstant;
import com.eltaieb.microservice.notificationservice.dao.JpaNotificationTemplate;
import com.eltaieb.microservice.notificationservice.entity.NotificationTemplateEntity;
import com.eltaieb.microservice.notificationservice.service.api.NotificationService;
import com.eltaieb.microservice.notificationservice.service.model.Message;
import com.eltaieb.microservice.notificationservice.service.model.NotificationModel;

@Service
public class NotificationServiceBean implements NotificationService {

	private JpaNotificationTemplate jpaNotificationTemplate;
	public NotificationServiceBean(JpaNotificationTemplate jpaNotificationTemplate )
	{
		this.jpaNotificationTemplate=jpaNotificationTemplate;
		
		
	}
	
	@Override
	public Message populateNotification(NotificationModel notificationModel) throws ServiceException {
		
		NotificationTemplateEntity notificationTemplateEntity = loadNotificationChannelEntity(notificationModel);
		Message message = populateMessage(notificationTemplateEntity , notificationModel);
		System.out.println(message);
		
		return message;
	}

	private Message populateMessage(NotificationTemplateEntity notificationTemplateEntity,
			NotificationModel notificationModel) {
			String subject = populateString(notificationTemplateEntity.getSubject() , notificationModel.getParameters());
			String body = populateString(notificationTemplateEntity.getBody() , notificationModel.getParameters());
		
			Message message = new Message();
			message.setSubject(subject);
			message.setBody(body);
			message.setTo(notificationModel.getTo());
			message.setReferenceType(notificationModel.getReferenceType());
			message.setReferenceNumber(notificationModel.getReferenceNumber());
			message.setDateTime(LocalDateTime.now());
			return message; 
	}

	private String populateString(String template, Map<String, Object> parameters) {
		if(template==null) return BaseServiceConstant.EMPTY_STRING;
		ST st = new ST(template);
		parameters.forEach((k,v)->{
			st.add(k, v);

		});
		return st.render();
	}

	private NotificationTemplateEntity loadNotificationChannelEntity(NotificationModel notificationModel) throws ServiceException {
		 Optional<NotificationTemplateEntity> notificationEntityTemplateOptional = 	jpaNotificationTemplate.getNotificationTemplate(notificationModel.getCode(), notificationModel.getLocale(), notificationModel.getChannel());;
		 if(Boolean.FALSE == notificationEntityTemplateOptional.isPresent())
		 {
			 notificationEntityTemplateOptional = jpaNotificationTemplate.getNotificationTemplate(notificationModel.getCode(), ServiceConstant.DEFAULT_NOTIFICATION_LOCALE, notificationModel.getChannel());
		 }
		 
		 return notificationEntityTemplateOptional.orElseThrow(  ()-> new ServiceException(ErrorMessageCode.NO_SUCH_NOTIFICATION_WITH_PROVIDED_CODE)  );
	}

	 

	 

}
