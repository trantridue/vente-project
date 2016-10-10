package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the fund database table.
 * 
 */
@Entity
@Table(name="fund")
@NamedQuery(name="Fund.findAll", query="SELECT f FROM Fund f")
public class Fund implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String description;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to FundExchange
	@OneToMany(mappedBy="fund1", fetch=FetchType.EAGER)
	private Set<FundExchange> fundExchanges1;

	//bi-directional many-to-one association to FundExchange
	@OneToMany(mappedBy="fund2", fetch=FetchType.EAGER)
	private Set<FundExchange> fundExchanges2;

	//bi-directional many-to-one association to FundHistory
	@OneToMany(mappedBy="fund", fetch=FetchType.EAGER)
	private Set<FundHistory> fundHistories;

	//bi-directional many-to-one association to ProviderPaymentFund
	@OneToMany(mappedBy="fund", fetch=FetchType.EAGER)
	private Set<ProviderPaymentFund> providerPaymentFunds;

	//bi-directional many-to-one association to SpendingFund
	@OneToMany(mappedBy="fund", fetch=FetchType.EAGER)
	private Set<SpendingFund> spendingFunds;

	//bi-directional many-to-one association to UserPaymentFund
	@OneToMany(mappedBy="fund", fetch=FetchType.EAGER)
	private Set<UserPaymentFund> userPaymentFunds;

	public Fund() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<FundExchange> getFundExchanges1() {
		return this.fundExchanges1;
	}

	public void setFundExchanges1(Set<FundExchange> fundExchanges1) {
		this.fundExchanges1 = fundExchanges1;
	}

	public FundExchange addFundExchanges1(FundExchange fundExchanges1) {
		getFundExchanges1().add(fundExchanges1);
		fundExchanges1.setFund1(this);

		return fundExchanges1;
	}

	public FundExchange removeFundExchanges1(FundExchange fundExchanges1) {
		getFundExchanges1().remove(fundExchanges1);
		fundExchanges1.setFund1(null);

		return fundExchanges1;
	}

	public Set<FundExchange> getFundExchanges2() {
		return this.fundExchanges2;
	}

	public void setFundExchanges2(Set<FundExchange> fundExchanges2) {
		this.fundExchanges2 = fundExchanges2;
	}

	public FundExchange addFundExchanges2(FundExchange fundExchanges2) {
		getFundExchanges2().add(fundExchanges2);
		fundExchanges2.setFund2(this);

		return fundExchanges2;
	}

	public FundExchange removeFundExchanges2(FundExchange fundExchanges2) {
		getFundExchanges2().remove(fundExchanges2);
		fundExchanges2.setFund2(null);

		return fundExchanges2;
	}

	public Set<FundHistory> getFundHistories() {
		return this.fundHistories;
	}

	public void setFundHistories(Set<FundHistory> fundHistories) {
		this.fundHistories = fundHistories;
	}

	public FundHistory addFundHistory(FundHistory fundHistory) {
		getFundHistories().add(fundHistory);
		fundHistory.setFund(this);

		return fundHistory;
	}

	public FundHistory removeFundHistory(FundHistory fundHistory) {
		getFundHistories().remove(fundHistory);
		fundHistory.setFund(null);

		return fundHistory;
	}

	public Set<ProviderPaymentFund> getProviderPaymentFunds() {
		return this.providerPaymentFunds;
	}

	public void setProviderPaymentFunds(Set<ProviderPaymentFund> providerPaymentFunds) {
		this.providerPaymentFunds = providerPaymentFunds;
	}

	public ProviderPaymentFund addProviderPaymentFund(ProviderPaymentFund providerPaymentFund) {
		getProviderPaymentFunds().add(providerPaymentFund);
		providerPaymentFund.setFund(this);

		return providerPaymentFund;
	}

	public ProviderPaymentFund removeProviderPaymentFund(ProviderPaymentFund providerPaymentFund) {
		getProviderPaymentFunds().remove(providerPaymentFund);
		providerPaymentFund.setFund(null);

		return providerPaymentFund;
	}

	public Set<SpendingFund> getSpendingFunds() {
		return this.spendingFunds;
	}

	public void setSpendingFunds(Set<SpendingFund> spendingFunds) {
		this.spendingFunds = spendingFunds;
	}

	public SpendingFund addSpendingFund(SpendingFund spendingFund) {
		getSpendingFunds().add(spendingFund);
		spendingFund.setFund(this);

		return spendingFund;
	}

	public SpendingFund removeSpendingFund(SpendingFund spendingFund) {
		getSpendingFunds().remove(spendingFund);
		spendingFund.setFund(null);

		return spendingFund;
	}

	public Set<UserPaymentFund> getUserPaymentFunds() {
		return this.userPaymentFunds;
	}

	public void setUserPaymentFunds(Set<UserPaymentFund> userPaymentFunds) {
		this.userPaymentFunds = userPaymentFunds;
	}

	public UserPaymentFund addUserPaymentFund(UserPaymentFund userPaymentFund) {
		getUserPaymentFunds().add(userPaymentFund);
		userPaymentFund.setFund(this);

		return userPaymentFund;
	}

	public UserPaymentFund removeUserPaymentFund(UserPaymentFund userPaymentFund) {
		getUserPaymentFunds().remove(userPaymentFund);
		userPaymentFund.setFund(null);

		return userPaymentFund;
	}

}