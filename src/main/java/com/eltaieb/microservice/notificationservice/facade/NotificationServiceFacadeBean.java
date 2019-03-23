package com.eltaieb.microservice.notificationservice.facade;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.eltaieb.microservice.base.exception.ServiceException;
import com.eltaieb.microservice.base.model.NotificationChannel;
import com.eltaieb.microservice.notificationservice.config.ServiceConstant;
import com.eltaieb.microservice.notificationservice.model.UserDeviceModel;
import com.eltaieb.microservice.notificationservice.service.api.DeviceService;
import com.eltaieb.microservice.notificationservice.service.api.NotificationService;
import com.eltaieb.microservice.notificationservice.service.api.ValidationService;
import com.eltaieb.microservice.notificationservice.service.model.Message;
import com.eltaieb.microservice.notificationservice.service.model.NotificationModel;
import com.google.gson.Gson;
  
@Service
public class NotificationServiceFacadeBean implements NotificationServiceFacade {

	private DeviceService deviceService;
	private ValidationService validationService;
	private NotificationService notificationService;
    private RabbitTemplate rabbitTemplate;
	public NotificationServiceFacadeBean(DeviceService deviceService,
			ValidationService validationService,
			NotificationService notificationService,
			RabbitTemplate rabbitTemplate)
	{
		this.deviceService=deviceService;
		this.validationService=validationService;
		this.notificationService=notificationService;
		this.rabbitTemplate=rabbitTemplate;
	}
	
	@Override
	public void addUserDevice(Long userId, UserDeviceModel userDeviceModel) throws ServiceException {
		validationService.validate( userDeviceModel);
		deviceService.addUserDevice( userId,  userDeviceModel);
	}
	
	@Override
	public void populateAndSendNotification(NotificationModel notificationModel) throws ServiceException {

		validationService.validatePopulateAndSendNotification(notificationModel);
		Message message = notificationService.populateNotification(notificationModel);
		if(NotificationChannel.EMAIL == notificationModel.getChannel())
		{
			rabbitTemplate.convertAndSend(ServiceConstant.NOTIFICATION_MESSAGE_EXCHANGE_NAME,ServiceConstant.NOTIFICATION_MESSAGE_EMAIL_QUEUE_BINDING_KEY, new Gson().toJson(message));
		}else if(NotificationChannel.SMS == notificationModel.getChannel())
		{
			rabbitTemplate.convertAndSend(ServiceConstant.NOTIFICATION_MESSAGE_EXCHANGE_NAME,ServiceConstant.NOTIFICATION_MESSAGE_SMS_QUEUE_BINDING_KEY, new Gson().toJson(message));
		}
 	}
 
	 
 
	 
	 

	 

	 

}
