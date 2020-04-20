package com.neelesh.restws.restWebServices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping("/hello-bean")
	public HelloBean getHelloBean() {
		return new HelloBean("Hello world Bean!");
	}
	
	@GetMapping("/hello-bean/path-variable/{name}")
	public HelloBean getHelloBean(@PathVariable String name) {
		return new HelloBean(String.format("Hello world Bean!, %s ", name));
	}
}
