package com.zabuza.vente.ws.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import nordnet.tools.converter.Converter;
import nordnet.tools.converter.exceptions.ConverterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nordnet.common.wadl.WadlController;
import com.zabuza.vente.domain.model.Shop;
import com.zabuza.vente.domain.repository.ShopRepository;
import com.zabuza.vente.domain.repository.UserRepository;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * Web Service interface for shop
 *
 * @author dtrantri
 */

@Api(value = "shop", description = "shop API")
@Controller
@RequestMapping("/shop/")
public class ShopController extends WadlController {

	/** {@link UserRepository} userRepository. */
	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private Converter converter;

	@RequestMapping(value = "all", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ApiOperation(value = "Get All Shop", notes = "Find all shop")
	public List<Shop> getAllShop() throws ConverterException {
		List<Shop> shops = shopRepository.findAll();
		return shops;
	}
}
