package org.springboot.module.model;

import java.util.Date;

//import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//@ApiModel
public class User {
	@ApiModelProperty(allowableValues="001,002,003", required=true,value="a description for this property ",example="002")
	private String userId;
	
	@ApiModelProperty(allowableValues="xxx,yyy,zzz", example="zzz", allowEmptyValue=true)
	private String userName;
	
	@ApiModelProperty(hidden=true)
	private String password;
	
	@ApiModelProperty(example="18812345678")
	private String phone;
	
	@ApiModelProperty(value="this is a address property",example="fujian")
	private String address;
	
	@ApiModelProperty(dataType="String")
	private Date birthday;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", birthday=" + birthday + "]";
	}
	
	

}
