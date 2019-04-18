package org.springboot.module.controller;

import org.springboot.module.model.User;
import org.springboot.module.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "swagger test api demo")
@RestController
@RequestMapping(value = "/api")
public class HelloController {

	@Autowired
	private IUserService userService;

	@ApiOperation(value = "api /hello", notes = "this is one api about say hello")
	@RequestMapping(value = "/hello", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	public String hello() {
		System.out.println("rest request hello...");
		return "hello world";
	}

	@ApiOperation(value = "user/{id}", notes = "this is one api about load user")
	@RequestMapping(value = "user/{id}", method = RequestMethod.GET, consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public User load(@PathVariable String id) {
		System.out.println("load user by id: " + id);
		return userService.findById(id);
	}

}
