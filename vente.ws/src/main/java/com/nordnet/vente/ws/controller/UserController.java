package com.nordnet.vente.ws.controller;

import static com.nordnet.common.valueObject.utils.Null.isNullOrEmpty;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.List;

import nordnet.tools.converter.Converter;
import nordnet.tools.converter.exceptions.ConverterException;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nordnet.common.valueObject.identifier.Identifier;
import com.nordnet.common.wadl.WadlController;
import com.nordnet.vente.domain.model.User;
import com.nordnet.vente.services.UserService;
import com.nordnet.vente.ws.entities.Reference;
import com.wordnik.swagger.annotations.Api;

/**
 * Web Service interface for user
 *
 * @author dtrantri
 */

@Api(value = "vente", description = "vente API")
@Controller
@RequestMapping("/user/")
public class UserController extends WadlController {

	@Autowired
	private UserService userService;

	@Autowired
	private Converter converter;

	@RequestMapping(value = "all", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<com.nordnet.vente.ws.entities.User> getAllUser() throws ConverterException {
		List<com.nordnet.vente.ws.entities.User> users = new ArrayList<com.nordnet.vente.ws.entities.User>();
		for (User user : userService.getAllUser()) {
			users.add(converter.convert(user, com.nordnet.vente.ws.entities.User.class));
		}
		return users;
	}

	@RequestMapping(value = "/{name}", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<com.nordnet.vente.ws.entities.User> getUserByName(
			@RequestParam(required = false, value = "name") final String name) throws ConverterException {
		List<com.nordnet.vente.ws.entities.User> users = new ArrayList<com.nordnet.vente.ws.entities.User>();
		for (User user : userService.getUserByName(name)) {
			users.add(converter.convert(user, com.nordnet.vente.ws.entities.User.class));
		}
		return users;
	}

	@RequestMapping(value = "/", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<com.nordnet.vente.ws.entities.User> getUserByPeriod(
			@RequestParam(value = "startFrom", required = true) String startFrom,
			@RequestParam(value = "endTo", required = false) String endTo) throws ConverterException {
		// Handle parameters
		LocalDateTime startDate = LocalDateTime.parse(startFrom);
		LocalDateTime endDate = LocalDateTime.now();
		if (!isNullOrEmpty(endTo)) {
			endDate = LocalDateTime.parse(endTo);
		}

		List<com.nordnet.vente.ws.entities.User> users = new ArrayList<com.nordnet.vente.ws.entities.User>();
		for (User user : userService.getUserByPeriod(startDate, endDate)) {
			users.add(converter.convert(user, com.nordnet.vente.ws.entities.User.class));
		}
		return users;
	}

	@RequestMapping(value = "/add", method = POST, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
	@ResponseBody
	public Reference addUser(@RequestBody final com.nordnet.vente.ws.entities.User user) throws ConverterException {
		return Reference
				.builder()
				.id(Identifier.build(userService
						.addUser(converter.convert(user, com.nordnet.vente.domain.model.User.class)).getId().toString()))
				.build();
	}
}
