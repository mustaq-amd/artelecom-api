package com.ar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ar.dto.UserModel;
import com.ar.entity.ARUser;
import com.ar.exception.ItemAlreadyExistException;
import com.ar.exception.ResourceNotFoundException;
import com.ar.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public ARUser createUser(UserModel user) {

		if (userRepository.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistException("User already exist with the email " + user.getEmail());
		}

		if (userRepository.existsByMobile(user.getMobile())) {
			throw new ItemAlreadyExistException("User already exist with the mobile " + user.getMobile());
		}

		ARUser newUser = new ARUser();
		if(user.getRole() == null) {
			newUser.setRole("ADMIN");
		}
		BeanUtils.copyProperties(user, newUser);
		newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
		return userRepository.save(newUser);

	}

	@Override
	public ARUser readUser() throws ResourceNotFoundException {

		Long userId = getLoggedInUser().getUserId();
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with the id : " + userId));
	}

	@Override
	public ARUser updateUser(UserModel user) {

		ARUser existingUser = readUser();
		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
		existingUser.setPassword(
				user.getPassword() != null ? bcryptEncoder.encode(user.getPassword()) : existingUser.getPassword());
		existingUser
				.setDateOfBirth(user.getDateOfBirth() != null ? user.getDateOfBirth() : existingUser.getDateOfBirth());
		existingUser.setMobile(user.getMobile() != null ? user.getMobile() : existingUser.getMobile());

		return userRepository.save(existingUser);

	}

	@Override
	public void deleteUser() {
		ARUser user = readUser();
		userRepository.delete(user);

	}

	@Override
	public ARUser getLoggedInUser() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		String email = authentication.getName();

		return userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("user not exist for the email : " + email));

	}

}
