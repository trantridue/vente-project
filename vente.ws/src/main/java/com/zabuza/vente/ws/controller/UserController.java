package com.zabuza.vente.ws.controller;

import static com.nordnet.common.valueObject.utils.Null.isNullOrEmpty;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import nordnet.tools.converter.Converter;
import nordnet.tools.converter.exceptions.ConverterException;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nordnet.common.wadl.WadlController;
import com.zabuza.vente.domain.model.User;
import com.zabuza.vente.domain.repository.UserRepository;
import com.zabuza.vente.exception.VenteException;
import com.zabuza.vente.services.UserService;
import com.zabuza.vente.ws.entities.UserInfo;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * Web Service interface for user
 *
 * @author dtrantri
 */

@Api(value = "user", description = "user API")
@Controller
@RequestMapping("/user/")
public class UserController extends WadlController {

	@Autowired
	private UserService userService;

	/** {@link UserRepository} userRepository. */
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Converter converter;

	@RequestMapping(value = "all", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<com.zabuza.vente.domain.model.User> getAllUser()
			throws ConverterException {
//		List<com.zabuza.vente.ws.entities.User> users = new ArrayList<com.zabuza.vente.ws.entities.User>();
//		for (User user : userService.getAllUser()) {
//			users.add(converter.convert(user,
//					com.zabuza.vente.ws.entities.User.class));
//		}
//		return users;
		 return userService.getAllUser();
	}

	@RequestMapping(value = "/get/byname", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<com.zabuza.vente.ws.entities.User> getUserByName(
			@RequestParam(required = false, value = "name") final String name)
			throws ConverterException {
		List<com.zabuza.vente.ws.entities.User> users = new ArrayList<com.zabuza.vente.ws.entities.User>();
		for (User user : userService.getUserByName(name)) {
			users.add(converter.convert(user,
					com.zabuza.vente.ws.entities.User.class));
		}
		return users;
	}

	@RequestMapping(value = "/byperiod", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<com.zabuza.vente.ws.entities.User> getUserByPeriod(
			@RequestParam(value = "startFrom", required = true) String startFrom,
			@RequestParam(value = "endTo", required = false) String endTo)
			throws ConverterException {
		// Handle parameters
		LocalDateTime startDate = LocalDateTime.parse(startFrom);
		LocalDateTime endDate = LocalDateTime.now();
		if (!isNullOrEmpty(endTo)) {
			endDate = LocalDateTime.parse(endTo);
		}

		List<com.zabuza.vente.ws.entities.User> users = new ArrayList<com.zabuza.vente.ws.entities.User>();
		for (User user : userService.getUserByPeriod(startDate, endDate)) {
			users.add(converter.convert(user,
					com.zabuza.vente.ws.entities.User.class));
		}
		return users;
	}

	@RequestMapping(value = "/add", method = POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Add new user", notes = "Add a new user, return user with id")
	public com.zabuza.vente.ws.entities.User addUser(
			@RequestBody final UserInfo userInfo) throws ConverterException {
		// Handle input
		User user = converter.convert(userInfo,
				com.zabuza.vente.domain.model.User.class);

		// Service and return
		return converter.convert(userService.addUser(user),
				com.zabuza.vente.ws.entities.User.class);
	}

	@RequestMapping(value = "/update/byusername", method = POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "update use by username", notes = "update user by username")
	public com.zabuza.vente.ws.entities.User updateUserByUserName(
			@RequestBody final UserInfo userInfo) throws ConverterException,
			VenteException {
		// Handle input
		User user = converter.convert(userInfo,
				com.zabuza.vente.domain.model.User.class);

		// Service and return
		return converter.convert(userService.updateUserByUserName(user),
				com.zabuza.vente.ws.entities.User.class);
	}

	@RequestMapping(value = "/delete/{userid}", method = DELETE, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "delete user", notes = "Delete user by id, if true then deleting success")
	public Boolean deleteUser(@PathVariable("userid") final Long userid)
			throws VenteException {
		return userService.deleteUser(userid);
	}
}
