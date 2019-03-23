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

import com.eltaieb.microservice.base.model.NotificationChannel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="NotificationTemplate")
@Table(name="notification_template")
public class NotificationTemplateEntity implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="notification_template_pk_seq")
	@SequenceGenerator(name="notification_template_pk_seq" , sequenceName="notification_template_pk_seq",allocationSize=1)
	private Long id;
	
	private String code;
	
	private String locale;
	
	@Enumerated(EnumType.STRING)
	@Column(name="notification_channel")
	private NotificationChannel notificationChannel;
	
	private String subject;
	
	private String body;
	@Column(name="is_active")
	private Boolean active;
	
	
}
