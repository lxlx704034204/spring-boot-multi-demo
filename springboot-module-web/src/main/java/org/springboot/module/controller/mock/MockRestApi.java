package org.springboot.module.controller.mock;

import java.util.Date;

import org.springboot.module.model.User;
import org.springboot.module.vo.ResultSet;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "mock rest apis")
//@CrossOrigin
//@CrossOrigin(origins= {"http://localhost:3000"},methods= {RequestMethod.POST})
//@CrossOrigin(methods= {RequestMethod.POST})
@RestController
@RequestMapping(value = "/mock/api")
public class MockRestApi {

	@ApiOperation(value = "mock get", notes = "one rest api about get method")
	@GetMapping("/get/test")
	public ResultSet<String> mockGet() {
		System.out.println("MockRestApi.mockGet()...");
		ResultSet<String> result = new ResultSet<String>(1, "success load", "hello world");
		return result;
	}

	@ApiOperation(value = "mock get err", notes = "one rest api about get method that run exception")
	@GetMapping("/get/testErr")
	public ResultSet<String> mockGetErr() {
		System.out.println("MockRestApi.mockGetErr()...");
		int err = 1 / 0;
		return null;
	}

	@ApiOperation(value = "mock post user success", notes = "one rest api about post method that success add user")
	@PostMapping("/post/test")
	public ResultSet<User> mockPost(@RequestBody User user) {
		System.out.println("MockRestApi.mockPost()...");
		user.setPassword("******");
		user.setBirthday(new Date());
		ResultSet<User> resultSet = new ResultSet<User>(1, "success add user", user);
		return resultSet;
	}
	
	@ApiOperation(value = "mock post user error", notes = "one rest api about post method that error add user")
	@PostMapping("/post/testErr")
	public ResultSet<User> mockPostErr(@RequestBody User user) {
		System.out.println("MockRestApi.mockPost()...");
		int err = 1 / 0;
		return null;
	}

}
