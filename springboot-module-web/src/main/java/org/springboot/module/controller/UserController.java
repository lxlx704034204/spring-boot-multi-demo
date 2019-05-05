package org.springboot.module.controller;

import java.util.Date;
import java.util.List;

import org.springboot.module.model.OraclePage;
import org.springboot.module.model.User;
import org.springboot.module.service.ISPUserService;
import org.springboot.module.vo.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@Api(tags = "restful api about user")
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {

	@Autowired
	private ISPUserService userService;

	@GetMapping(value = "/login")
	public String login(Model model, @RequestParam(value = "error", required = false) String error) {
		if (error != null) {
			model.addAttribute("error", "用户名或密码错误");
		}
		return "forward:/login_page.html";
	}

	@ApiOperation(value = "", notes = "this is one api about list user")
	@GetMapping(value = "")
	public List<User> findUsers() {
		System.out.println("UserController.findUsers()");
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
	public ResultSet<Integer> addUser(@RequestBody User user) {
		System.out.println("UserController.addUser()");
//		User user = new User();
//		user.setUserId("userId");
//		user.setUserName("userName");
//		user.setPassword("password");
//		user.setPhone("phone");
//		user.setAddress("address");
		user.setBirthday(new Date());
		ResultSet<Integer> result = ResultSet.newSuccessResult(1);
		try {
			userService.addUser(user);	
		} catch (Exception e) {
			log.error("save user became error", e);
			result = ResultSet.newFailedResult(0);
		}
		return result;
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

//	@ApiOperation(value = "/page", notes = "this is one api about page user")
//	@GetMapping(value = "/page")
//	public OraclePage<User> findUsersByPage(@RequestParam(defaultValue = "1") Integer pageIndex,
//			@RequestParam(defaultValue = "5") Integer pageSize) {
//		System.out.println("UserController.findUsersByPage()");
//		OraclePage<User> page = new OraclePage<>();
//		page.setCurPage(pageIndex);
//		page.setPageSize(pageSize);
//		userService.findUsersByPage(page);
//		return page;
//	}
	
	@ApiOperation(value = "/page", notes = "this is one api about page user")
	@GetMapping(value = "/page")
	public ResultSet<OraclePage<User>> findUsersByPage(@RequestParam(defaultValue = "1") Integer pageIndex,
			@RequestParam(defaultValue = "5") Integer pageSize) {
		System.out.println("UserController.findUsersByPage()");
		OraclePage<User> page = new OraclePage<>();
		page.setCurPage(pageIndex);
		page.setPageSize(pageSize);
		userService.findUsersByPage(page);
		
		return ResultSet.newSuccessResult(page);
	}
	
}
