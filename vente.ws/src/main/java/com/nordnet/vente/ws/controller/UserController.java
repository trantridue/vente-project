package com.nordnet.vente.ws.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

import nordnet.tools.converter.Converter;
import nordnet.tools.converter.exceptions.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nordnet.common.wadl.WadlController;
import com.nordnet.vente.domain.model.User;
import com.nordnet.vente.services.UserService;
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
		try {
			List<User> userModels = userService.getAllUser();
			for (User user : userModels) {
				users.add(converter.convert(user, com.nordnet.vente.ws.entities.User.class));
			}
			return users;
		} catch (Exception e) {
			throw e;
		}
	}

}
