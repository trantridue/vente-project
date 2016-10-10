package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_pay_history database table.
 * 
 */
@Entity
@Table(name="customer_pay_history")
@NamedQuery(name="CustomerPayHistory.findAll", query="SELECT c FROM CustomerPayHistory c")
public class CustomerPayHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private float amount;

	@Column(length=45)
	private String description;

	//bi-directional many-to-one association to ExportFacture
	@ManyToOne
	@JoinColumn(name="export_facture_id", nullable=false)
	private ExportFacture exportFacture;

	public CustomerPayHistory() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ExportFacture getExportFacture() {
		return this.exportFacture;
	}

	public void setExportFacture(ExportFacture exportFacture) {
		this.exportFacture = exportFacture;
	}

}