package org.springboot.module.model;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class User {
	@ApiModelProperty(allowableValues = "001,002,003", required = true, value = "a description for this property ", example = "002")
	private String userId;

	@ApiModelProperty(allowableValues = "xxx,yyy,zzz", example = "zzz", allowEmptyValue = true)
	private String userName;

	@ApiModelProperty(hidden = true)
	private String password;

	@ApiModelProperty(hidden = true)
	private String role;

	@ApiModelProperty(example = "18812345678")
	private String phone;

	@ApiModelProperty(value = "this is a address property", example = "fujian")
	private String address;

	@ApiModelProperty(dataType = "String")
	private Date birthday;
	
}
