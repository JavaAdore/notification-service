package com.eltaieb.microservice.notificationservice.service.api;

import com.eltaieb.microservice.notificationservice.model.UserDeviceModel;

public interface DeviceService {

	void addUserDevice(Long userId, UserDeviceModel userDeviceModel);

}
