package com.eltaieb.microservice.notificationservice.model;

import com.eltaieb.microservice.base.model.DeviceType;

import lombok.Data;

@Data
public class UserDeviceModel {
	
	private String token;
	
	private DeviceType deviceType;
	
}
