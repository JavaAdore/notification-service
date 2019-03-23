package com.eltaieb.microservice.base.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eltaieb.microservice.base.feignclient.config.ContentExtractorFeignConfiuration;

 
@FeignClient(name="INFO-SERVICE",configuration=ContentExtractorFeignConfiuration.class)
public interface InfoService {

 	@RequestMapping(path ="/information" , method=RequestMethod.GET)
	String getInformation();
	 
}
