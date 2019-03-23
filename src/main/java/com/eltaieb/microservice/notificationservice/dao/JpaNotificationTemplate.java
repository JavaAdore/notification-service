package com.eltaieb.microservice.notificationservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eltaieb.microservice.base.model.NotificationChannel;
import com.eltaieb.microservice.notificationservice.entity.NotificationTemplateEntity;

public interface JpaNotificationTemplate extends CrudRepository<NotificationTemplateEntity,Long>{

	@Query("select nt from NotificationTemplate nt where nt.code =:#{#code}   and  nt.locale =:#{#locale}  and nt.notificationChannel =:#{#notificationChannel}  and  nt.active =:#{T(java.lang.Boolean).TRUE} ")
	public Optional<NotificationTemplateEntity> getNotificationTemplate(@Param("code") String code ,@Param("locale") String locale ,@Param("notificationChannel") NotificationChannel notificationChannel  );
	

}
