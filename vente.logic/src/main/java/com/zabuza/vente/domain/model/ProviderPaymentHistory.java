package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the provider_payment_history database table.
 * 
 */
@Entity
@Table(name="provider_payment_history")
@NamedQuery(name="ProviderPaymentHistory.findAll", query="SELECT p FROM ProviderPaymentHistory p")
public class ProviderPaymentHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(nullable=false, length=1000)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	private Date updateDate;

	@Column(name="user_id", nullable=false)
	private int userId;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	@JoinColumn(name="provider_id", nullable=false)
	private Provider provider;

	//bi-directional many-to-one association to ProviderPaymentFund
	@ManyToOne
	@JoinColumn(name="provider_payment_fund_id", nullable=false)
	private ProviderPaymentFund providerPaymentFund;

	public ProviderPaymentHistory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public ProviderPaymentFund getProviderPaymentFund() {
		return this.providerPaymentFund;
	}

	public void setProviderPaymentFund(ProviderPaymentFund providerPaymentFund) {
		this.providerPaymentFund = providerPaymentFund;
	}

}