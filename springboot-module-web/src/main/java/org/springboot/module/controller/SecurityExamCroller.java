package org.springboot.module.controller;

import org.springboot.module.vo.ResultSet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Exmaple API for security Demo ")
@RestController
@RequestMapping(value = "/api/security")
public class SecurityExamCroller {
	
	@ApiOperation(value = "/open", notes = " access with role user")
	@GetMapping(value = "/open")
	public ResultSet<String> testOpen() {
		System.out.println("SecurityExamCroller.testOpen()");
		return ResultSet.newSuccessResult("hello user");
	}
	
	@ApiOperation(value = "/limit", notes = " access with role admin")
	@GetMapping(value = "/limit")
	public ResultSet<String> testLimit() {
		System.out.println("SecurityExamCroller.testLimit()");
		return ResultSet.newSuccessResult("hello admin");
	}

}
