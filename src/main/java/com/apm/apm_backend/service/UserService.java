package com.apm.apm_backend.service;

import java.util.List;
import com.apm.apm_backend.model.UserModel;

public interface UserService {
	String createUser(UserModel userDetails);
	String updateUser(UserModel userDetails);
	String deleteUser(Integer userId);
	UserModel getUser(Integer userId);
	List<UserModel> getAllUsers();
	String confirmEmail(String token);
}
