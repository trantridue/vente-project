package com.nordnet.vente.services.impl;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nordnet.common.valueObject.utils.Null;
import com.nordnet.vente.domain.model.User;
import com.nordnet.vente.domain.repository.UserRepository;
import com.nordnet.vente.exception.VenteErrorCode;
import com.nordnet.vente.exception.VenteException;
import com.nordnet.vente.services.UserService;
import com.nordnet.vente.utils.Md5Utils;
import com.nordnet.vente.utils.StringUtils;

@Service("userService")
public class UserServiceImpl implements UserService {

	/** {@link UserRepository} userRepository. */
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() throws VenteException {
		List<User> users = userRepository.findAll();
		if (users.size() > 10) {
			throw new VenteException(VenteErrorCode.OVER_LIMIT_NBR_USER, users.size());
		} else {
			return users;
		}
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
	public User addUser(User user) throws VenteException {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new VenteException(VenteErrorCode.CANNOT_ADD_USER, user.getUsername());
		}
	}

	@Override
	public Boolean deleteUser(Long userid) throws VenteException {
		// Service and return
		try {
			userRepository.delete(userid);
			return true;
		} catch (Exception e) {
			throw new VenteException(VenteErrorCode.CANNOT_DELETE_USER_ID, userid);
		}
	}

	@Override
	public User updateUserByUserName(User user, String username) throws VenteException {
		// Service and return
		User userDB = userRepository.findByUsername(username);
		if (Null.isNullOrEmpty(userDB)) {
			throw new VenteException(VenteErrorCode.USERNAME_NOT_FOUND, username);
		}
		try {
			userDB.setUsername(StringUtils.getNotNullString(user.getUsername(), userDB.getUsername()));
			userDB.setAddress(StringUtils.getNotNullString(user.getAddress(), userDB.getAddress()));
			userDB.setEmail(StringUtils.getNotNullString(user.getEmail(), userDB.getEmail()));
			userDB.setName(StringUtils.getNotNullString(user.getName(), userDB.getName()));
			userDB.setTel(StringUtils.getNotNullString(user.getTel(), userDB.getTel()));
			userDB.setPassword(!Null.isNullOrEmpty(user.getPassword()) ? Md5Utils.getMd5(user.getPassword()) : userDB
					.getPassword());
			userDB.setUpdateDate(LocalDateTime.now());
			return userRepository.save(userDB);
		} catch (Exception e) {
			throw new VenteException(VenteErrorCode.CANNOT_UPDATE_USER_BY_USERNAME, username, e.getMessage());
		}
	}
}
