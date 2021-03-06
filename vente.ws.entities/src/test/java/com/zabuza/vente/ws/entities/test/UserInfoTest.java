package com.zabuza.vente.ws.entities.test;

import static com.nordnet.common.valueObject.utils.JSon.canBeJSonSerialized;
import static com.nordnet.common.valueObject.utils.Utils.hasProtectedEmptyConstructorEqualsAndHashCodeAndCompareTo;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.zabuza.vente.ws.entities.UserInfo;

/**
 * generic test for {@link UserInfo} entity.
 *
 * this class is auto generated by the com.nordnet.common project : entities-maven-plugin,
 * do not edit this class directly, all change will be lost on next build ...
 */
@SuppressWarnings("unused")
public class UserInfoTest extends GlobalTestCase {

	/**
	 * test  for UserInfo  methods.
	 * <li> constructors,
	 * <li> {@link UserInfo#equals(Object)},
	 * <li> {@link UserInfo#hashCode()},
	 * <li> {@link UserInfo#toString()}
	 * <li> {@link UserInfo#compareTo(UserInfo)}
	 */
	@Test
	public void successTest() {
		UserInfo tmp = UserInfo.builder()
			.username("String")
			.password("String")
			.name("String")
			.email("String")
			.tel("String")
			.address("String").build();
		assertTrue(hasProtectedEmptyConstructorEqualsAndHashCodeAndCompareTo(UserInfo.class, tmp));
		assertTrue(canBeJSonSerialized(tmp));
	}
}
