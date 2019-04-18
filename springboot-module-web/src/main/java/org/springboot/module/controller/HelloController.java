package org.springboot.module.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "swagger test api demo")
@RestController
@RequestMapping(value = "/api")
public class HelloController {
	
	@ApiOperation(value = "api /hello", notes = "this is one api about say hello")
	@RequestMapping(value = "/hello", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public String hello() {
		System.out.println("rest request hello...");
		return "hello world";
	}

}
