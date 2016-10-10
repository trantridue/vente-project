package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the spending_fund database table.
 * 
 */
@Entity
@Table(name="spending_fund")
@NamedQuery(name="SpendingFund.findAll", query="SELECT s FROM SpendingFund s")
public class SpendingFund implements Serializable {
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

	//bi-directional many-to-one association to SpendingHistory
	@OneToMany(mappedBy="spendingFund", fetch=FetchType.EAGER)
	private Set<SpendingHistory> spendingHistories;

	public SpendingFund() {
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

	public Set<SpendingHistory> getSpendingHistories() {
		return this.spendingHistories;
	}

	public void setSpendingHistories(Set<SpendingHistory> spendingHistories) {
		this.spendingHistories = spendingHistories;
	}

	public SpendingHistory addSpendingHistory(SpendingHistory spendingHistory) {
		getSpendingHistories().add(spendingHistory);
		spendingHistory.setSpendingFund(this);

		return spendingHistory;
	}

	public SpendingHistory removeSpendingHistory(SpendingHistory spendingHistory) {
		getSpendingHistories().remove(spendingHistory);
		spendingHistory.setSpendingFund(null);

		return spendingHistory;
	}

}