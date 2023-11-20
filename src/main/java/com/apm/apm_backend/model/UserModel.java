package com.apm.apm_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_type")
	private String userType;

	@Column(name = "user_email")
	private String userEmail;
	private String password;
	private boolean status;

	public UserModel() {
	}

	public UserModel(Integer userId, String firstName, String userName, String userType, String userEmail, String password, boolean status) {
		this.userId = userId;
		this.firstName = firstName;
		this.userName = userName;
		this.userType = userType;
		this.userEmail = userEmail;
		this.password = password;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
