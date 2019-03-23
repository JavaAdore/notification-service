package com.eltaieb.microservice.notificationservice.facade;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.notificationservice.model.UserDeviceModel;
import com.eltaieb.microservice.notificationservice.service.model.NotificationModel;

public interface NotificationServiceFacade {

	void addUserDevice(Long userId, UserDeviceModel userDeviceModel)throws ServiceException;

	void populateAndSendNotification(NotificationModel verificationStatusModel) throws ServiceException;

 
 
}
