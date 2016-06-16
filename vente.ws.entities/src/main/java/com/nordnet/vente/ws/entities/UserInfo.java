package com.nordnet.vente.ws.entities;

import org.slf4j.LoggerFactory;

/**
 * UserInfo.
 *
 * this class is auto generated by the com.nordnet.common project : entities-maven-plugin,
 * do not edit this class directly, all change will be lost on next build ...
 *
 * @author DUE
 *
 */
public class UserInfo implements Comparable<UserInfo> {

	/** {@link String} username. */
	protected final String username;

	/** {@link String} password. */
	protected final String password;

	/** {@link String} name. */
	protected final String name;

	/** {@link String} email. */
	protected final String email;

	/** {@link String} tel. */
	protected final String tel;

	/** {@link String} address. */
	protected final String address;

	/**
	 * default deprecated Constructor.
	 *
	 * @deprecated
	 */
	@Deprecated
	protected UserInfo() {
		username = null;
		password = null;
		name = null;
		email = null;
		tel = null;
		address = null;
	}

	/**
	 * Constructor.
	 *
	 * @param builder the {@link Builder} to use.
	 */
	protected UserInfo(final Builder builder) {
		username = builder.username;
		password = builder.password;
		name = builder.name;
		email = builder.email;
		tel = builder.tel;
		address = builder.address;
	
		// check parameters
	}

	/**
	 * builder of {@link UserInfo}.
	 *
	 * @return new {@link Builder} for {@link UserInfo}
	 */
	public static Builder builder() {
		return new Builder();
	}
	/**
	 * Builder for {@link UserInfo}.
	 *
	 * @author DUE
	 *
	 */
	public static class Builder {
		
		/** {@link String} username. */
		protected String username;

		/** {@link String} password. */
		protected String password;

		/** {@link String} name. */
		protected String name;

		/** {@link String} email. */
		protected String email;

		/** {@link String} tel. */
		protected String tel;

		/** {@link String} address. */
		protected String address;

		/** default protected Constructor. */
		protected Builder() {
			super();
		}

		/**
		 * Setter of username.
		 *
		 * @param username
		 *			{@link String} the username to set.
		 * @return this {@link Builder}
		 */
		public Builder username(final String username) {
			this.username = username;
			return this;
		}

		/**
		 * Setter of password.
		 *
		 * @param password
		 *			{@link String} the password to set.
		 * @return this {@link Builder}
		 */
		public Builder password(final String password) {
			this.password = password;
			return this;
		}

		/**
		 * Setter of name.
		 *
		 * @param name
		 *			{@link String} the name to set.
		 * @return this {@link Builder}
		 */
		public Builder name(final String name) {
			this.name = name;
			return this;
		}

		/**
		 * Setter of email.
		 *
		 * @param email
		 *			{@link String} the email to set.
		 * @return this {@link Builder}
		 */
		public Builder email(final String email) {
			this.email = email;
			return this;
		}

		/**
		 * Setter of tel.
		 *
		 * @param tel
		 *			{@link String} the tel to set.
		 * @return this {@link Builder}
		 */
		public Builder tel(final String tel) {
			this.tel = tel;
			return this;
		}

		/**
		 * Setter of address.
		 *
		 * @param address
		 *			{@link String} the address to set.
		 * @return this {@link Builder}
		 */
		public Builder address(final String address) {
			this.address = address;
			return this;
		}

		/**
		 * build new {@link UserInfo}.
		 *
		 * @return new {@link UserInfo} from this {@link Builder}
		 */
		public UserInfo build() {
			return new UserInfo(this);
		}

	}
	/**
	 * Getter of username.
	 *
	 * @return {@link String} the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Getter of password.
	 *
	 * @return {@link String} the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Getter of name.
	 *
	 * @return {@link String} the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter of email.
	 *
	 * @return {@link String} the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Getter of tel.
	 *
	 * @return {@link String} the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Getter of address.
	 *
	 * @return {@link String} the address
	 */
	public String getAddress() {
		return address;
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof UserInfo)) {
			return false;
		}
		UserInfo userinfo = (UserInfo) obj;
		return com.nordnet.common.valueObject.utils.Equals.TRUE
			.andEquals(getUsername(), userinfo.getUsername())
			.andEquals(getPassword(), userinfo.getPassword())
			.andEquals(getName(), userinfo.getName())
			.andEquals(getEmail(), userinfo.getEmail())
			.andEquals(getTel(), userinfo.getTel())
			.andEquals(getAddress(), userinfo.getAddress()).isEquals();
	}

	@Override
	public int hashCode() {
	return new com.nordnet.common.valueObject.utils.HashCode(null)
		.append(getUsername())
		.append(getPassword())
		.append(getName())
		.append(getEmail())
		.append(getTel())
		.append(getAddress()).hashCode();
	}

	@Override
	public String toString() {
		try {
			return com.nordnet.common.valueObject.utils.JSon.toPrettyJson(this);
		} catch (com.fasterxml.jackson.core.JsonProcessingException jpe) {
			LoggerFactory.getLogger(UserInfo.class).error("error with toString", jpe);
			return super.toString();
		}
	}

	@Override
	public int compareTo(final UserInfo o) {
		return new com.nordnet.common.valueObject.utils.Compare(true, true)
		.andCompare(getUsername(), o.getUsername())
		.andCompare(getPassword(), o.getPassword())
		.andCompare(getName(), o.getName())
		.andCompare(getEmail(), o.getEmail())
		.andCompare(getTel(), o.getTel())
		.andCompare(getAddress(), o.getAddress()).compare();
	}


}