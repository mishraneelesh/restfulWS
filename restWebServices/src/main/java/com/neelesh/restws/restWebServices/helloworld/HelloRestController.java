package com.neelesh.restws.restWebServices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/hello-bean")
	public HelloBean getHelloBean() {
		return new HelloBean("Hello world Bean!");
	}
	
	@GetMapping("/hello-bean/path-variable/{name}")
	public HelloBean getHelloBean(@PathVariable String name) {
		return new HelloBean(String.format("Hello world Bean!, %s ", name));
	}
	
	@GetMapping(path ="/hello-bean-internationalized")
	public String getHelloBeanI18N() {
		return  messageSource.getMessage("good.morning.message", null ,null,LocaleContextHolder.getLocale());
		
	}
}
