package com.eltaieb.microservice.notificationservice.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.base.model.ErrorMessageCode;
import com.eltaieb.microservice.notificationservice.model.UserDeviceModel;
import com.eltaieb.microservice.notificationservice.service.api.ValidationService;
import com.eltaieb.microservice.notificationservice.service.model.NotificationModel;

@Service
public class ValidationServiceBean implements ValidationService {

	@Override
	public void validate(UserDeviceModel userDeviceModel) throws ServiceException {

		if(StringUtils.isEmpty(userDeviceModel.getToken()))
		{
			throw new ServiceException(ErrorMessageCode.DEVICE_TOKEN_MUST_BE_PROVIDED);
		}
	}

	@Override
	public void validatePopulateAndSendNotification(NotificationModel verificationStatusModel) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

}
