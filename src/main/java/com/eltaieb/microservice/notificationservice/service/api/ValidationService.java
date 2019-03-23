package com.eltaieb.microservice.notificationservice.service.api;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.notificationservice.model.UserDeviceModel;
import com.eltaieb.microservice.notificationservice.service.model.NotificationModel;

public interface ValidationService {

	void validate(UserDeviceModel userDeviceModel) throws ServiceException;

	void validatePopulateAndSendNotification(NotificationModel verificationStatusModel)throws ServiceException;

}
