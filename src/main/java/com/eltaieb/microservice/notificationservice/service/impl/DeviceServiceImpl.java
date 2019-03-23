package com.eltaieb.microservice.notificationservice.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eltaieb.microservice.notificationservice.dao.JpaUserDeviceDao;
import com.eltaieb.microservice.notificationservice.entity.UserDeviceEntity;
import com.eltaieb.microservice.notificationservice.model.UserDeviceModel;
import com.eltaieb.microservice.notificationservice.service.api.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {

	private JpaUserDeviceDao jpaUserDeviceDao;
	public DeviceServiceImpl(JpaUserDeviceDao jpaUserDeviceDao)
	{
		this.jpaUserDeviceDao=jpaUserDeviceDao;
	}
	
	 
	
	@Override
	public void addUserDevice(Long userId, UserDeviceModel userDeviceModel) {
	Optional<UserDeviceEntity> userDeviceEntityOptional =	jpaUserDeviceDao.findUserDeviceEntity(userId,userDeviceModel.getToken(), userDeviceModel.getDeviceType(), Boolean.TRUE);
	if(userDeviceEntityOptional.isPresent())
	{
		// token is already added and active .. so it has no sense to add it again
		return;
	}
	UserDeviceEntity userDeviceEntity = toUserDeviceEntity(userId, userDeviceModel)	;
		jpaUserDeviceDao.save(userDeviceEntity);
	} 

	private UserDeviceEntity toUserDeviceEntity(Long userId,UserDeviceModel userDeviceModel) {
		UserDeviceEntity userDeviceEntity =new UserDeviceEntity();
		userDeviceEntity.setDeviceType(userDeviceModel.getDeviceType());
		userDeviceEntity.setToken(userDeviceModel.getToken());
		userDeviceEntity.setUserId(userId);
		userDeviceEntity.setActive(Boolean.TRUE); 
 		return userDeviceEntity;
	}



	

}
