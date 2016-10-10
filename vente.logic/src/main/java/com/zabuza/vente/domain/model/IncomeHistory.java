package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the income_history database table.
 * 
 */
@Entity
@Table(name="income_history")
@NamedQuery(name="IncomeHistory.findAll", query="SELECT i FROM IncomeHistory i")
public class IncomeHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="income_code", unique=true, nullable=false, length=32)
	private String incomeCode;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date date;

	@Column(length=255)
	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="income_date", nullable=false)
	private Date incomeDate;

	@Column(name="is_familly", nullable=false)
	private byte isFamilly;

	public IncomeHistory() {
	}

	public String getIncomeCode() {
		return this.incomeCode;
	}

	public void setIncomeCode(String incomeCode) {
		this.incomeCode = incomeCode;
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

	public Date getIncomeDate() {
		return this.incomeDate;
	}

	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}

	public byte getIsFamilly() {
		return this.isFamilly;
	}

	public void setIsFamilly(byte isFamilly) {
		this.isFamilly = isFamilly;
	}

}