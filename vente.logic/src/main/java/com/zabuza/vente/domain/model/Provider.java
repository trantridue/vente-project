package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the provider database table.
 * 
 */
@Entity
@Table(name="provider")
@NamedQuery(name="Provider.findAll", query="SELECT p FROM Provider p")
public class Provider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String address;

	@Column(length=1000)
	private String description;

	@Column(nullable=false, length=255)
	private String name;

	@Column(nullable=false, length=16)
	private String phone;

	//bi-directional many-to-one association to ImportFacture
	@OneToMany(mappedBy="provider", fetch=FetchType.EAGER)
	private Set<ImportFacture> importFactures;

	//bi-directional many-to-one association to ProviderPaymentHistory
	@OneToMany(mappedBy="provider", fetch=FetchType.EAGER)
	private Set<ProviderPaymentHistory> providerPaymentHistories;

	//bi-directional many-to-one association to ReturnProviderFactureProduct
	@OneToMany(mappedBy="provider", fetch=FetchType.EAGER)
	private Set<ReturnProviderFactureProduct> returnProviderFactureProducts;

	public Provider() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<ImportFacture> getImportFactures() {
		return this.importFactures;
	}

	public void setImportFactures(Set<ImportFacture> importFactures) {
		this.importFactures = importFactures;
	}

	public ImportFacture addImportFacture(ImportFacture importFacture) {
		getImportFactures().add(importFacture);
		importFacture.setProvider(this);

		return importFacture;
	}

	public ImportFacture removeImportFacture(ImportFacture importFacture) {
		getImportFactures().remove(importFacture);
		importFacture.setProvider(null);

		return importFacture;
	}

	public Set<ProviderPaymentHistory> getProviderPaymentHistories() {
		return this.providerPaymentHistories;
	}

	public void setProviderPaymentHistories(Set<ProviderPaymentHistory> providerPaymentHistories) {
		this.providerPaymentHistories = providerPaymentHistories;
	}

	public ProviderPaymentHistory addProviderPaymentHistory(ProviderPaymentHistory providerPaymentHistory) {
		getProviderPaymentHistories().add(providerPaymentHistory);
		providerPaymentHistory.setProvider(this);

		return providerPaymentHistory;
	}

	public ProviderPaymentHistory removeProviderPaymentHistory(ProviderPaymentHistory providerPaymentHistory) {
		getProviderPaymentHistories().remove(providerPaymentHistory);
		providerPaymentHistory.setProvider(null);

		return providerPaymentHistory;
	}

	public Set<ReturnProviderFactureProduct> getReturnProviderFactureProducts() {
		return this.returnProviderFactureProducts;
	}

	public void setReturnProviderFactureProducts(Set<ReturnProviderFactureProduct> returnProviderFactureProducts) {
		this.returnProviderFactureProducts = returnProviderFactureProducts;
	}

	public ReturnProviderFactureProduct addReturnProviderFactureProduct(ReturnProviderFactureProduct returnProviderFactureProduct) {
		getReturnProviderFactureProducts().add(returnProviderFactureProduct);
		returnProviderFactureProduct.setProvider(this);

		return returnProviderFactureProduct;
	}

	public ReturnProviderFactureProduct removeReturnProviderFactureProduct(ReturnProviderFactureProduct returnProviderFactureProduct) {
		getReturnProviderFactureProducts().remove(returnProviderFactureProduct);
		returnProviderFactureProduct.setProvider(null);

		return returnProviderFactureProduct;
	}

}