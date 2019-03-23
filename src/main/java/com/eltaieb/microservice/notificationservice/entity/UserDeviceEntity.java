package com.eltaieb.microservice.notificationservice.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.eltaieb.microservice.base.model.DeviceType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="UserDevice")
@Table(name="user_device")
public class UserDeviceEntity implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_device_pk_seq")
	@SequenceGenerator(name="user_device_pk_seq" , sequenceName="user_device_pk_seq",allocationSize=1)
	private Long id;
	
	@Column(name="token")
	private String token;
	
	@Enumerated(EnumType.STRING)
	@Column(name="device_type")
	private DeviceType deviceType;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="is_active")
	private Boolean active;
	
	 
	
	
	
	
}
