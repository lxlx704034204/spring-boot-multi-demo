package org.springboot.module.controller;

import java.util.Date;
import java.util.List;

import org.springboot.module.model.User;
import org.springboot.module.service.ISPUserService;
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

@Api(tags = "restful api about user")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private ISPUserService userService;

	@ApiOperation(value = "", notes = "this is one api about list user")
	@GetMapping(value = "")
	public List<User> findUsers() {
		System.out.println("UserController.select()");
		List<User> users = userService.findUsers();
		return users;
	}

	@ApiOperation(value = "/{userId}", notes = "this is one api about load user")
	@GetMapping(value = "/{userId}")
	public User findUserById(@PathVariable String userId) {
		System.out.println("UserController.findUserById()");
		User user = userService.findUserById(userId);
		System.out.println(user);
		return user;
	}

	@ApiOperation(value = "/add", notes = "this is one api about add user")
	@PostMapping(value = "/add")
	public String addUser(@RequestBody User user) {
		System.out.println("UserController.addUser()");
//		User user = new User();
//		user.setUserId("userId");
//		user.setUserName("userName");
//		user.setPassword("password");
//		user.setPhone("phone");
//		user.setAddress("address");
		user.setBirthday(new Date());
		userService.addUser(user);
		return "add user success";
	}

	@ApiOperation(value = "/update", notes = "this is one api about update user")
	@PutMapping(value = "/update")
	public String updateUser(@RequestBody User user) {
		System.out.println("UserController.updateUser()");
//		User user = new User();
//		user.setUserId("userId");
//		user.setUserName("userName");
//		user.setPassword("password");
//		user.setPhone("phone");
//		user.setAddress("address");
		user.setBirthday(new Date());
		userService.updateUser(user);
		return "update user success";
	}

	@ApiOperation(value = "/{userId}", notes = "this is one api about delete user")
	@DeleteMapping(value = "/{userId}")
	public String deleteUserById(@PathVariable String userId) {
		System.out.println("UserController.testUser()");
		userService.deleteUserById(userId);
		return "delete user success";
	}

}
