package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_payment_history database table.
 * 
 */
@Entity
@Table(name="user_payment_history")
@NamedQuery(name="UserPaymentHistory.findAll", query="SELECT u FROM UserPaymentHistory u")
public class UserPaymentHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private float bonus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false, length=1000)
	private String description;

	@Column(name="for_user_id", nullable=false)
	private int forUserId;

	@Temporal(TemporalType.DATE)
	@Column(name="next_pay_date", nullable=false)
	private Date nextPayDate;

	@Column(name="update_date", length=45)
	private String updateDate;

	@Column(name="user_id", nullable=false)
	private int userId;

	//bi-directional many-to-one association to UserPaymentFund
	@ManyToOne
	@JoinColumn(name="user_payment_fund_id", nullable=false)
	private UserPaymentFund userPaymentFund;

	public UserPaymentHistory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBonus() {
		return this.bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getForUserId() {
		return this.forUserId;
	}

	public void setForUserId(int forUserId) {
		this.forUserId = forUserId;
	}

	public Date getNextPayDate() {
		return this.nextPayDate;
	}

	public void setNextPayDate(Date nextPayDate) {
		this.nextPayDate = nextPayDate;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserPaymentFund getUserPaymentFund() {
		return this.userPaymentFund;
	}

	public void setUserPaymentFund(UserPaymentFund userPaymentFund) {
		this.userPaymentFund = userPaymentFund;
	}

}