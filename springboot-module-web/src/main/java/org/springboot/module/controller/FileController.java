package org.springboot.module.controller;

import org.springboot.module.vo.ResultSet;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "a restful api about files operation")
@RestController(value = "/api/files")
public class FileController {
	
	@ApiOperation(value = "uploadFile", notes = "this is one api about upload file")
	@PostMapping(value = "/upload")
	public ResultSet<Integer> uploadFile(@RequestPart("file") MultipartFile file, String comment) {
		System.out.println("### FileController.uploadFile()");
		System.out.println("comment " + comment);
		System.out.println("file " + file);
		ResultSet<Integer> relust = ResultSet.newSuccessResult(1);
		return relust;
	}

}
