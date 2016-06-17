package com.nordnet.vente.services;

import java.util.List;

import org.joda.time.LocalDateTime;

import com.nordnet.vente.domain.model.User;
import com.nordnet.vente.exception.VenteException;

public interface UserService {

	public List<User> getAllUser();

	public List<User> getUserByName(String name);

	public List<User> getUserByPeriod(LocalDateTime startDate, LocalDateTime endDate);

	public User addUser(User user);

	public Boolean deleteUser(Long userid) throws VenteException;
}
