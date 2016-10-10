package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the spending_history database table.
 * 
 */
@Entity
@Table(name="spending_history")
@NamedQuery(name="SpendingHistory.findAll", query="SELECT s FROM SpendingHistory s")
public class SpendingHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="branch_id")
	private int branchId;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(length=255)
	private String description;

	@Column(name="is_familly", nullable=false)
	private byte isFamilly;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	private Date updateDate;

	@Column(name="user_id", nullable=false)
	private int userId;

	//bi-directional many-to-one association to SpendingFund
	@ManyToOne
	@JoinColumn(name="spending_fund_id", nullable=false)
	private SpendingFund spendingFund;

	public SpendingHistory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBranchId() {
		return this.branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
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

	public byte getIsFamilly() {
		return this.isFamilly;
	}

	public void setIsFamilly(byte isFamilly) {
		this.isFamilly = isFamilly;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public SpendingFund getSpendingFund() {
		return this.spendingFund;
	}

	public void setSpendingFund(SpendingFund spendingFund) {
		this.spendingFund = spendingFund;
	}

}