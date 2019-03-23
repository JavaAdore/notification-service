package com.eltaieb.microservice.notificationservice.service.api;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.notificationservice.service.model.Message;
import com.eltaieb.microservice.notificationservice.service.model.NotificationModel;

public interface NotificationService {

	Message populateNotification(NotificationModel verificationStatusModel) throws ServiceException;

 

 
	 
	 
	
	
}
