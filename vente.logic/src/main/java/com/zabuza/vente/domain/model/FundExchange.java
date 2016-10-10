package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the fund_exchange database table.
 * 
 */
@Entity
@Table(name="fund_exchange")
@NamedQuery(name="FundExchange.findAll", query="SELECT f FROM FundExchange f")
public class FundExchange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private float amount;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(length=255)
	private String description;

	@Column(nullable=false)
	private float ratio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	private Date updateDate;

	@Column(name="user_id", nullable=false)
	private int userId;

	//bi-directional many-to-one association to Fund
	@ManyToOne
	@JoinColumn(name="fund_id_source", nullable=false)
	private Fund fund1;

	//bi-directional many-to-one association to Fund
	@ManyToOne
	@JoinColumn(name="fund_id_destination", nullable=false)
	private Fund fund2;

	public FundExchange() {
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

	public float getRatio() {
		return this.ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
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

	public Fund getFund1() {
		return this.fund1;
	}

	public void setFund1(Fund fund1) {
		this.fund1 = fund1;
	}

	public Fund getFund2() {
		return this.fund2;
	}

	public void setFund2(Fund fund2) {
		this.fund2 = fund2;
	}

}