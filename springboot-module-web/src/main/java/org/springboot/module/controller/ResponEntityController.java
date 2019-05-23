package org.springboot.module.controller;

import org.springboot.module.model.User;
import org.springboot.module.vo.ResultSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "a restful api for responEntity demo")
@RestController
@RequestMapping(value = "/api/resdemo")
public class ResponEntityController {
	
	@ApiOperation(value = "getTest", notes = "response ok")
	@GetMapping("/getTest")
	public ResponseEntity<User> getTest() {
		User user = new User();
		user.setUserName("userName");
		user.setPhone("123456");
		return ResponseEntity.ok(user);
	}

	@ApiOperation(value = "getTest2", notes = "response badRequest")
	@GetMapping("/getTest2")
	public ResponseEntity<User> getTest2() {
		User user = new User();
		user.setUserName("userName");
		user.setPhone("123456");
		return ResponseEntity.badRequest().body(user);
	}
	
	
	@ApiOperation(value = "getTest3", notes = "response ResultSet<User>")
	@GetMapping("/getTest3")
	public ResponseEntity<ResultSet<User>> getTest3() {
		User user = new User();
		user.setUserName("userName");
		user.setPhone("123456");
		return ResponseEntity.ok(new ResultSet<User>(1, "hello", user));
	}
	//400	Bad Request	客户端请求的语法错误，服务器无法理解
	//403	Forbidden	服务器理解请求客户端的请求，但是拒绝执行此请求
	//405	Method Not Allowed	客户端请求中的方法被禁止
	//406	Not Acceptable	服务器无法根据客户端请求的内容特性完成请求
	//412	Precondition Failed	客户端请求信息的先决条件错误
	//412	Precondition Failed	客户端请求信息的先决条件错误
	@ApiOperation(value = "getTest4", notes = "response 412	Precondition Failed")
	@GetMapping("/getTest4")
	public ResponseEntity<User> getTest4() {
		User user = new User();
		user.setUserName("userName");
		user.setPhone("123456");
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(user);
	}
	
	@ApiOperation(value = "postTest", notes = "response 304 Not Modified")
	@PostMapping("/postTest")
	public ResponseEntity<User> postTest() {
		User user = new User();
		user.setUserName("userName");
		user.setPhone("123456");
		return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(user);
	}
	
	@ApiOperation(value = "postTest2", notes = "response 417 Expectation Failed")
	@PostMapping("/postTest2")
	public ResponseEntity<User> postTest2() {
		User user = new User();
		user.setUserName("userName");
		user.setPhone("123456");
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(user);
	}
	
	@ApiOperation(value = "postTest3", notes = "response 422 Unprocessable Entity")
	@PostMapping("/postTest3")
	public ResponseEntity<User> postTest3() {
		User user = new User();
		user.setUserName("userName");
		user.setPhone("123456");
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(user);
	}
	
	@ApiOperation(value = "postTest4", notes = "response 422 Unprocessable Entity")
	@PostMapping("/postTest4")
	public ResponseEntity<User> postTest4() {
		User user = new User();
		user.setUserName("userName");
		user.setPhone("123456");
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(user);
	}
	
	@ApiOperation(value = "postTest5", notes = "response 400 Bad Request")
	@PostMapping("/postTest5")
	public ResponseEntity<ResultSet<User>> postTest5() {
		User user = new User();
		user.setUserName("userName");
		user.setPhone("123456");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResultSet<User>(-100, "your request is error", user));
	}
	
	


}
