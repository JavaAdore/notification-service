package com.eltaieb.microservice.notificationservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eltaieb.microservice.base.model.DeviceType;
import com.eltaieb.microservice.notificationservice.entity.UserDeviceEntity;

public interface JpaUserDeviceDao extends CrudRepository<UserDeviceEntity,Long>{

	@Query("select ud from UserDevice ud where ud.userId =:#{#userId} and ud.active =:#{T(java.lang.Boolean).TRUE} ")
	public List<UserDeviceEntity> getActiveUserDevices(@Param("userId") Long userId);
	
	@Query("select ud from UserDevice ud where ud.userId =:#{#userId} and ud.active =:#{#active} and ud.token =:#{#token} and  ud.deviceType =:#{#deviceType} ")
	public Optional<UserDeviceEntity> findUserDeviceEntity(@Param("userId") Long userId,@Param("token")  String token, @Param("deviceType")  DeviceType deviceType, @Param("active")  Boolean active);

}
