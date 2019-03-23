package com.eltaieb.microservice.rest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.base.model.ServiceResponse;
import com.eltaieb.microservice.notificationservice.facade.NotificationServiceFacade;
import com.eltaieb.microservice.notificationservice.service.model.NotificationModel;

import lombok.extern.java.Log;

@Log
@RestController()
@RequestMapping("notification")
public class NotificationController {

	private NotificationServiceFacade notificationServiceFacade;

	public NotificationController(NotificationServiceFacade notificationServiceFacade) {
		this.notificationServiceFacade = notificationServiceFacade;
	}

	@RequestMapping(path = "send", method = RequestMethod.POST)
	public ServiceResponse<Object> sendNotification(@RequestBody NotificationModel verificationStatusModel)
			throws ServiceException {
		notificationServiceFacade.populateAndSendNotification(verificationStatusModel);
		return null;

	}

}