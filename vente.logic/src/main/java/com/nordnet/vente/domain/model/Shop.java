package com.nordnet.vente.domain.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Shop.
 *
 * this class is auto generated by the com.nordnet.common project : entities-maven-plugin, do not edit this class
 * directly, all change will be lost on next build ...
 *
 * @author DUE TRAN TRI
 *
 */
@Entity
@Table(name = "shop")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public class Shop implements Comparable<Shop> {

	/** identifier. */
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", columnDefinition = "int(11)", nullable = false)
	protected Long id;

	/** {@link String} name. */
	protected final String name;

	/** {@link String} description. */
	protected final String description;

	/**
	 * listes des {@link User} de la Shop.
	 */
	@OneToMany(fetch = EAGER, cascade = ALL)
	@JoinColumn(name = "shop_id")
	private List<User> users;

	/**
	 * default deprecated Constructor.
	 *
	 * @deprecated
	 */
	@Deprecated
	protected Shop() {
		id = null;
		name = null;
		description = null;
		users = null;
	}

	/**
	 * Constructor.
	 *
	 * @param builder
	 *            the {@link Builder} to use.
	 */
	protected Shop(final Builder builder) {
		id = builder.id;
		name = builder.name;
		description = builder.description;
		users = builder.users;

		// check parameters
		com.nordnet.common.valueObject.utils.Null.checkNotNullOrEmpty("id", id);
	}

	/**
	 * builder of {@link Shop}.
	 *
	 * @return new {@link Builder} for {@link Shop}
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder for {@link Shop}.
	 *
	 * @author DUE TRAN TRI
	 *
	 */
	public static class Builder {

		/** {@link Long} id. */
		protected Long id;

		/** {@link String} name. */
		protected String name;

		/** {@link String} description. */
		protected String description;

		/** List<{@link User}> users. */
		protected List<User> users;

		/** default protected Constructor. */
		protected Builder() {
			super();
		}

		/**
		 * Setter of id.
		 *
		 * @param id
		 *            {@link Long} the id to set.
		 * @return this {@link Builder}
		 */
		public Builder id(final Long id) {
			this.id = id;
			return this;
		}

		/**
		 * Setter of name.
		 *
		 * @param name
		 *            {@link String} the name to set.
		 * @return this {@link Builder}
		 */
		public Builder name(final String name) {
			this.name = name;
			return this;
		}

		/**
		 * Setter of description.
		 *
		 * @param description
		 *            {@link String} the description to set.
		 * @return this {@link Builder}
		 */
		public Builder description(final String description) {
			this.description = description;
			return this;
		}

		public Builder users(final List<User> users) {
			this.users = users;
			return this;
		}

		/**
		 * build new {@link Shop}.
		 *
		 * @return new {@link Shop} from this {@link Builder}
		 */
		public Shop build() {
			return new Shop(this);
		}

	}

	/**
	 * Getter of id.
	 *
	 * @return {@link Long} the id
	 */
	public Long getId() {
		return id;
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
	 * Getter of description.
	 *
	 * @return {@link String} the description
	 */
	public String getDescription() {
		return description;
	}

	@Override
	public boolean equals(final Object obj) {
		if (!(obj instanceof Shop)) {
			return false;
		}
		Shop shop = (Shop) obj;
		return com.nordnet.common.valueObject.utils.Equals.TRUE.andEquals(getId(), shop.getId())
				.andEquals(getName(), shop.getName()).andEquals(getDescription(), shop.getDescription()).isEquals();
	}

	@Override
	public int hashCode() {
		return new com.nordnet.common.valueObject.utils.HashCode(null).append(getId()).append(getName())
				.append(getDescription()).hashCode();
	}

	@Override
	public String toString() {
		try {
			return com.nordnet.common.valueObject.utils.JSon.toPrettyJson(this);
		} catch (com.fasterxml.jackson.core.JsonProcessingException jpe) {
			LoggerFactory.getLogger(Shop.class).error("error with toString", jpe);
			return super.toString();
		}
	}

	@Override
	public int compareTo(final Shop o) {
		return new com.nordnet.common.valueObject.utils.Compare(true, true).andCompare(getId(), o.getId())
				.andCompare(getName(), o.getName()).andCompare(getDescription(), o.getDescription()).compare();
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
}
