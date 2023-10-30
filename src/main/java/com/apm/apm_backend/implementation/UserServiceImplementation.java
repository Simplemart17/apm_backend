package com.apm.apm_backend.implementation;

import java.util.List;
import org.springframework.stereotype.Service;
import com.apm.apm_backend.model.UserModel;
import com.apm.apm_backend.repository.UserRepository;
import com.apm.apm_backend.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	UserRepository userRepository;

	public UserServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public String createUser(UserModel userdetails) {
		userRepository.save(userdetails);
		return "Success";
	}

	@Override
	public String updateUser(UserModel userdetails) {
		userRepository.save(userdetails);
		return "Success";
	}

	@Override
	public String deleteUser(Integer userId) {
		userRepository.deleteById(userId);
		return "Success";
	}

	@Override
	public UserModel getuser(Integer userId) {
		return userRepository.findById(userId).get();
	}

	@Override
	public List<UserModel> getAllUsers() {
		return userRepository.findAll();
	}

}
