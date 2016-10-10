package com.zabuza.vente.ws.converter;

import org.dozer.CustomConverter;
import org.joda.time.LocalDateTime;

import com.nordnet.common.valueObject.exception.InvalidArgumentException;
import com.zabuza.vente.domain.model.User;
import com.zabuza.vente.exception.VenteException;
import com.zabuza.vente.utils.Md5Utils;
import com.zabuza.vente.ws.entities.Shop;

/**
 * The Class User.
 *
 * @author dtrantri
 */
public class UserConverter implements CustomConverter {

	@Override
	public Object convert(final Object destination, final Object source, final Class<?> destinationClass,
			final Class<?> sourceClass) {

		if (source instanceof User) {
			User user = (User) source;

			return com.zabuza.vente.ws.entities.User
					.builder()
					.username(user.getUsername())
					.address(user.getAddress())
					.password(user.getPassword())
					.email(user.getEmail())
					.build();
		} else if (source instanceof com.zabuza.vente.ws.entities.UserInfo) {
			com.zabuza.vente.ws.entities.UserInfo userInfo = (com.zabuza.vente.ws.entities.UserInfo) source;

			try {
//				return com.zabuza.vente.domain.model.User.builder().username(userInfo.getUsername())
//						.address(userInfo.getAddress()).password(Md5Utils.getMd5(userInfo.getPassword()))
//						.email(userInfo.getEmail()).tel(userInfo.getTel()).name(userInfo.getName())
//						.createDate(LocalDateTime.now()).updateDate(LocalDateTime.now()).build();
				return new com.zabuza.vente.domain.model.User();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		throw new InvalidArgumentException(source.getClass().getName(), "bad source for conversion");
	}
}
