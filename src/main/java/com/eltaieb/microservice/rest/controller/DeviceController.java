package com.eltaieb.microservice.rest.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eltaieb.microservice.base.aspect.SecurityUtilityBean;
import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.base.model.ServiceResponse;
import com.eltaieb.microservice.base.model.SuccessServiceResponse;
import com.eltaieb.microservice.notificationservice.facade.NotificationServiceFacade;
import com.eltaieb.microservice.notificationservice.model.UserDeviceModel;

import lombok.extern.java.Log;

@Log
@RestController()
@RequestMapping("device")
public class DeviceController {

	private NotificationServiceFacade notificationServiceFacade;
	
	public DeviceController(NotificationServiceFacade notificationServiceFacade)
	{
		this.notificationServiceFacade=notificationServiceFacade;
	}
	
	
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ServiceResponse<Object> addUserDevice(@RequestBody UserDeviceModel userDeviceModel) throws ServiceException
	{
		Long userId=  SecurityUtilityBean.loadCurrentUserId();
		notificationServiceFacade.addUserDevice(userId , userDeviceModel);
		return new SuccessServiceResponse<Object>("success");
		
	}

}
