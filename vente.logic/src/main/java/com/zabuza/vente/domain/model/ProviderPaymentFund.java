package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the provider_payment_fund database table.
 * 
 */
@Entity
@Table(name="provider_payment_fund")
@NamedQuery(name="ProviderPaymentFund.findAll", query="SELECT p FROM ProviderPaymentFund p")
public class ProviderPaymentFund implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private float amount;

	//bi-directional many-to-one association to Fund
	@ManyToOne
	@JoinColumn(name="fund_id", nullable=false)
	private Fund fund;

	//bi-directional many-to-one association to ProviderPaymentHistory
	@OneToMany(mappedBy="providerPaymentFund", fetch=FetchType.EAGER)
	private Set<ProviderPaymentHistory> providerPaymentHistories;

	public ProviderPaymentFund() {
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

	public Set<ProviderPaymentHistory> getProviderPaymentHistories() {
		return this.providerPaymentHistories;
	}

	public void setProviderPaymentHistories(Set<ProviderPaymentHistory> providerPaymentHistories) {
		this.providerPaymentHistories = providerPaymentHistories;
	}

	public ProviderPaymentHistory addProviderPaymentHistory(ProviderPaymentHistory providerPaymentHistory) {
		getProviderPaymentHistories().add(providerPaymentHistory);
		providerPaymentHistory.setProviderPaymentFund(this);

		return providerPaymentHistory;
	}

	public ProviderPaymentHistory removeProviderPaymentHistory(ProviderPaymentHistory providerPaymentHistory) {
		getProviderPaymentHistories().remove(providerPaymentHistory);
		providerPaymentHistory.setProviderPaymentFund(null);

		return providerPaymentHistory;
	}

}