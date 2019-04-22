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

@Api(tags = "a restful api genreated by swagger")
@RestController
@RequestMapping(value = "/api/hello")
public class HelloController {

	@Autowired
	private IUserService userService;

	@ApiOperation(value = "api /hello", notes = "this is one api about say hello")
	@GetMapping(value = "")
	public String hello() {
		System.out.println("rest request hello...");
		return "hello world";
	}

	@ApiOperation(value = "/{id}", notes = "this is one api about load entity")
	@GetMapping(value = "/{id}")
	public User load(@PathVariable String id) {
		System.out.println("load user by id: " + id);
		return userService.findById(id);
	}

	@ApiOperation(value = "hello/{id}", notes = "this is one api about delete entity")
	@DeleteMapping(value = "/{id}")
	public String delete(@PathVariable String id) {
		System.out.println("load user by id: " + id);
		return "delete sucess";
	}

	@ApiOperation(value = "hello/add", notes = "this is one api about save entity")
	@PostMapping(value = "/add")
	public User add(@RequestBody User user) {
		System.out.println("user: " + user);
		return user;
	}

	@ApiOperation(value = "hello/update", notes = "this is one api about update entity")
	@PutMapping(value = "/update")
	public User update(@RequestBody User user) {
		System.out.println("user: " + user);
		return user;
	}

}
