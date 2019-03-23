package com.eltaieb.microservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableRabbit
@EnableAsync
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
@PropertySource(value = { "classpath:db.properties","classpath:rabbit-mq.properties"})
public class NotificationServiceApplication   {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
		 
	}
 
//	 @Bean
//	 public CommandLineRunner commandLineRunner(RabbitTemplate rabbitTemplate)
//	 {
//		 return (args)->{
//			 
// 		 };
//	 }
 
}
