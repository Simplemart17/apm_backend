package com.apm.apm_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.apm.apm_backend.model.UserModel;
import com.apm.apm_backend.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserApiController {
	UserService userService;

	public UserApiController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UserModel> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("{userId}")
	@ResponseStatus(HttpStatus.OK)
	public UserModel getUser(@PathVariable("userId") Integer userId) {
		return userService.getUser(userId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createUser(@RequestBody UserModel userDetails) {

        return userService.createUser(userDetails);
	}
	
	@PutMapping("{userId}")
	@ResponseStatus(HttpStatus.OK)
	public String updateUser(@RequestBody UserModel userDetails, @PathVariable("userId") Integer userId) {
		userDetails.setUserId(userId);

		return userService.updateUser(userDetails);
	}
	
	
	@DeleteMapping("{userId}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteUser(@PathVariable("userId") Integer userId) {
		return userService.deleteUser(userId);
	}

	@RequestMapping(value = "/confirm", method = {RequestMethod.GET, RequestMethod.POST})
	public String confirmUserAccount(@RequestParam("token") String confirmationToken) {
		return userService.confirmEmail(confirmationToken);
	}

}
