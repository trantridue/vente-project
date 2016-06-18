package com.nordnet.vente.test.domain.model;

import static com.nordnet.common.valueObject.utils.JSon.canBeJSonSerialized;
import static com.nordnet.common.valueObject.utils.Utils.hasProtectedEmptyConstructorEqualsAndHashCodeAndCompareTo;
import static org.junit.Assert.assertTrue;

import org.joda.time.LocalDateTime;
import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.nordnet.vente.domain.model.Shop;
import com.nordnet.vente.domain.model.User;
import com.nordnet.vente.test.GlobalTestCase;

public class UserTest extends GlobalTestCase {

	/** successful test. */
	@Test
	@DatabaseSetup(value = "/dataset/initDb.xml")
	public void successful() {
		User user =
				User.builder().username("username").password("password").name("name").address("address")
						.tel("123456789").createDate(LocalDateTime.now()).updateDate(LocalDateTime.now())
						.shop(Shop.builder().id(1L).name("shop name").description("des").build())
						.email("trantridue@gmail.com").build();
		assertTrue(hasProtectedEmptyConstructorEqualsAndHashCodeAndCompareTo(User.class, user));
		assertTrue(canBeJSonSerialized(user));
	}
}
