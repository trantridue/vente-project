package com.zabuza.vente.services;

import java.util.List;

import org.joda.time.LocalDateTime;

import com.zabuza.vente.domain.model.User;
import com.zabuza.vente.exception.VenteException;

public interface UserService {

	public List<User> getAllUser();

	public List<User> getUserByName(String name);

	public List<User> getUserByPeriod(LocalDateTime startDate, LocalDateTime endDate);

	public User addUser(User user);

	public User updateUserByUserName(User user) throws VenteException;

	public Boolean deleteUser(Long userid) throws VenteException;
}
