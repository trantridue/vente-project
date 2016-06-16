/**
 *
 */
package com.nordnet.vente.ws.converter;

import org.dozer.CustomConverter;
import org.joda.time.LocalDateTime;

import com.nordnet.common.valueObject.exception.InvalidArgumentException;
import com.nordnet.vente.domain.model.User;

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

			return com.nordnet.vente.ws.entities.User.builder().username(user.getUsername()).address(user.getAddress())
					.password(user.getPassword()).email(user.getEmail()).name(user.getName()).id(user.getId())
					.tel(user.getTel()).createDate(user.getCreateDate()).updateDate(user.getUpdateDate()).build();
		} else if (source instanceof com.nordnet.vente.ws.entities.UserInfo) {
			com.nordnet.vente.ws.entities.UserInfo userInfo = (com.nordnet.vente.ws.entities.UserInfo) source;

			return com.nordnet.vente.domain.model.User.builder().username(userInfo.getUsername())
					.address(userInfo.getAddress()).password(userInfo.getPassword()).email(userInfo.getEmail())
					.tel(userInfo.getTel()).name(userInfo.getName()).createDate(LocalDateTime.now())
					.updateDate(LocalDateTime.now()).build();
		}
		throw new InvalidArgumentException(source.getClass().getName(), "bad source for conversion");
	}
}
