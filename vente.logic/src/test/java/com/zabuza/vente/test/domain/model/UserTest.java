package com.zabuza.vente.test.domain.model;

import static com.nordnet.common.valueObject.utils.JSon.canBeJSonSerialized;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.zabuza.vente.domain.model.User;
import com.zabuza.vente.test.GlobalTestCase;

public class UserTest extends GlobalTestCase {

	/** successful test. */
	@Test
	@DatabaseSetup(value = "/dataset/initDb.xml")
	public void successful() {
		User user = new User();
		//assertTrue(canBeJSonSerialized(user));
	}
}
