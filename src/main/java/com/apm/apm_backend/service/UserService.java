package com.apm.apm_backend.service;

import java.util.List;
import com.apm.apm_backend.model.UserModel;

public interface UserService {
	public String createUser(UserModel userdetails);
	public String updateUser(UserModel userdetails);
	public String deleteUser(Integer userId);
	public UserModel getuser(Integer userId);
	public List<UserModel> getAllUsers();
}
