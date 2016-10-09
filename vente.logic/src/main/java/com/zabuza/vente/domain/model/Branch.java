package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the branch database table.
 * 
 */
@Entity
@Table(name="branch")
@NamedQuery(name="Branch.findAll", query="SELECT b FROM Branch b")
public class Branch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=255)
	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false, length=45)
	private String label;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="branch")
	private Set<User> users;

	public Branch() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setBranch(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setBranch(null);

		return user;
	}

}