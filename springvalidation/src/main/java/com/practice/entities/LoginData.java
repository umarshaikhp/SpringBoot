package com.practice.entities;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginData {

@NotBlank(message = "User Name can not be empty !!")
@Size(min = 3,max = 12,message = "User Name must be 3 - 12 characters")
private String userName;

@Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",message = "Invalid Email !!")
private String email;

@AssertTrue(message = "Must agree terms and condition !!")
private boolean agreed;
public boolean isAgreed() {
	return agreed;
}
public void setAgreed(boolean agreed) {
	this.agreed = agreed;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "LoginData [userName=" + userName + ", email=" + email + ", agreed=" + agreed + ", isAgreed()=" + isAgreed()
			+ ", getUserName()=" + getUserName() + ", getEmail()=" + getEmail() + ", getClass()=" + getClass()
			+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}

}
