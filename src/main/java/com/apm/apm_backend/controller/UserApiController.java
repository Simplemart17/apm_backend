package com.apm.apm_backend.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apm.apm_backend.model.UserModel;
import com.apm.apm_backend.service.UserService;

@RestController
@RequestMapping("/users")
public class UserApiController
{
	UserService userService;

	public UserApiController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<UserModel> getUsers()
	{
		return userService.getAllUsers();
	}
	
	@GetMapping("{userId}")
	public UserModel getUser(@PathVariable("userId") Integer userId)
	{
		return userService.getuser(userId);
	}
	
	@PostMapping
	public String createUser(@RequestBody UserModel userDetails)
	{
		userService.createUser(userDetails);
		return "User created successfully";
	}
	
	@PutMapping
	public String updateUser(@RequestBody UserModel userDetails)
	{
		userService.createUser(userDetails);
		return "User updated successfully";
	}
	
	
	@DeleteMapping
	public String deleteUser(@PathVariable("userId") Integer userId)
	{
		userService.deleteUser(userId);
		return "User deleted successfully";
	}

}
