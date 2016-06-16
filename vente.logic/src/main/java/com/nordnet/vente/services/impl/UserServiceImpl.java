package com.nordnet.vente.services.impl;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nordnet.vente.domain.model.User;
import com.nordnet.vente.domain.repository.UserRepository;
import com.nordnet.vente.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	/** {@link UserRepository} userRepository. */
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public List<User> getUserByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public List<User> getUserByPeriod(LocalDateTime startDate, LocalDateTime endDate) {
		return userRepository.findByPeriod(startDate, endDate);
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}
}
