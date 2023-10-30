package com.apm.apm_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserModel
{
	@Id
	private Integer userId;
	private String firstName;
	private String userName;
	private String userType;
	private boolean status;
	
	public UserModel() {
	}

	public UserModel(Integer userId, String firstName, String userName, String userType, boolean status)
	{
		this.userId = userId;
		this.firstName = firstName;
		this.userName = userName;
		this.userType = userType;
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
