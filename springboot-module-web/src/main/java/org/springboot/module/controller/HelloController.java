package org.springboot.module.controller;

import org.springboot.module.model.User;
import org.springboot.module.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@GetMapping(value = "/hello")
	public String hello() {
		System.out.println("rest request hello...");
		return "hello world";
	}

	@ApiOperation(value = "user/{id}", notes = "this is one api about load user")
	@GetMapping(value = "user/{id}")
	public User load(@PathVariable String id) {
		System.out.println("load user by id: " + id);
		return userService.findById(id);
	}

	@ApiOperation(value = "user/{id}", notes = "this is one api about delete user")
	@DeleteMapping(value = "user/{id}")
	public String delete(@PathVariable String id) {
		System.out.println("load user by id: " + id);
		return "delete sucess";
	}

	@ApiOperation(value = "user/add", notes = "this is one api about save user")
	@PostMapping(value = "user/add")
	public User add(@RequestBody User user) {
		System.out.println("user: " + user);
		return user;
	}

	@ApiOperation(value = "user/update", notes = "this is one api about update user")
	@PutMapping(value = "user/update")
	public User update(@RequestBody User user) {
		System.out.println("user: " + user);
		return user;
	}

}
