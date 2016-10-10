package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the user_payment_fund database table.
 * 
 */
@Entity
@Table(name="user_payment_fund")
@NamedQuery(name="UserPaymentFund.findAll", query="SELECT u FROM UserPaymentFund u")
public class UserPaymentFund implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	private float amount;

	//bi-directional many-to-one association to Fund
	@ManyToOne
	@JoinColumn(name="fund_id", nullable=false)
	private Fund fund;

	//bi-directional many-to-one association to UserPaymentHistory
	@OneToMany(mappedBy="userPaymentFund", fetch=FetchType.EAGER)
	private Set<UserPaymentHistory> userPaymentHistories;

	public UserPaymentFund() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Fund getFund() {
		return this.fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public Set<UserPaymentHistory> getUserPaymentHistories() {
		return this.userPaymentHistories;
	}

	public void setUserPaymentHistories(Set<UserPaymentHistory> userPaymentHistories) {
		this.userPaymentHistories = userPaymentHistories;
	}

	public UserPaymentHistory addUserPaymentHistory(UserPaymentHistory userPaymentHistory) {
		getUserPaymentHistories().add(userPaymentHistory);
		userPaymentHistory.setUserPaymentFund(this);

		return userPaymentHistory;
	}

	public UserPaymentHistory removeUserPaymentHistory(UserPaymentHistory userPaymentHistory) {
		getUserPaymentHistories().remove(userPaymentHistory);
		userPaymentHistory.setUserPaymentFund(null);

		return userPaymentHistory;
	}

}