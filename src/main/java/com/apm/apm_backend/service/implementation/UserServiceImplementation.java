package com.apm.apm_backend.service.implementation;

import java.util.List;
import java.util.Optional;

import com.apm.apm_backend.model.ConfirmationTokenModel;
import com.apm.apm_backend.repository.ConfirmationTokenRepository;
import com.apm.apm_backend.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import com.apm.apm_backend.model.UserModel;
import com.apm.apm_backend.repository.UserRepository;
import com.apm.apm_backend.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	UserRepository userRepository;
	ConfirmationTokenRepository confirmationTokenRepository;
	EmailService emailService;
	String successMsg = "Success";

	public UserServiceImplementation(UserRepository userRepository, ConfirmationTokenRepository confirmationTokenRepository, EmailService emailService) {
		this.userRepository = userRepository;
		this.confirmationTokenRepository = confirmationTokenRepository;
		this.emailService = emailService;
	}

	@Override
	public String createUser(UserModel userDetails) {
		if (Boolean.TRUE.equals(userRepository.existsByUserEmail(userDetails.getUserEmail()))) {
			return "Email already exist";
		}

		userRepository.save(userDetails);

		ConfirmationTokenModel confirmationTokenModel = new ConfirmationTokenModel(userDetails);
		confirmationTokenRepository.save(confirmationTokenModel);

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(userDetails.getUserEmail());
		mailMessage.setSubject("User Registration!");
		mailMessage.setText("To confirm your account, click here: "+"http://localhost:8080/api/v1/users/confirm?token="+confirmationTokenModel.getConfirmationToken());

		emailService.sendEmail(mailMessage);

		return successMsg;
	}

	@Override
	public String confirmEmail(String confirmationToken) {
		ConfirmationTokenModel token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			UserModel userInfo = userRepository.findByUserEmailIgnoreCase(token.getUserEntity().getUserEmail());
			userInfo.setStatus(true);
			userRepository.save(userInfo);

			return "Email verified successfully!";
		}

		return "Email could not be verified!";
	}

	@Override
	public String updateUser(UserModel user) {
		userRepository.save(user);
		return successMsg;
	}

	@Override
	public String deleteUser(Integer userId) {
		userRepository.deleteById(userId);
		return successMsg;
	}

	@Override
	public UserModel getUser(Integer userId) {
		Optional<UserModel> findUser = userRepository.findById(userId);

        return findUser.orElseGet(UserModel::new);

    }

	@Override
	public List<UserModel> getAllUsers() {
		return userRepository.findAll();
	}
}
