package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the return_provider_facture database table.
 * 
 */
@Entity
@Table(name="return_provider_facture")
@NamedQuery(name="ReturnProviderFacture.findAll", query="SELECT r FROM ReturnProviderFacture r")
public class ReturnProviderFacture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=32)
	private String code;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(length=255)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	private Date updateDate;

	//bi-directional many-to-one association to ReturnProviderFactureProduct
	@OneToMany(mappedBy="returnProviderFacture", fetch=FetchType.EAGER)
	private Set<ReturnProviderFactureProduct> returnProviderFactureProducts;

	public ReturnProviderFacture() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Set<ReturnProviderFactureProduct> getReturnProviderFactureProducts() {
		return this.returnProviderFactureProducts;
	}

	public void setReturnProviderFactureProducts(Set<ReturnProviderFactureProduct> returnProviderFactureProducts) {
		this.returnProviderFactureProducts = returnProviderFactureProducts;
	}

	public ReturnProviderFactureProduct addReturnProviderFactureProduct(ReturnProviderFactureProduct returnProviderFactureProduct) {
		getReturnProviderFactureProducts().add(returnProviderFactureProduct);
		returnProviderFactureProduct.setReturnProviderFacture(this);

		return returnProviderFactureProduct;
	}

	public ReturnProviderFactureProduct removeReturnProviderFactureProduct(ReturnProviderFactureProduct returnProviderFactureProduct) {
		getReturnProviderFactureProducts().remove(returnProviderFactureProduct);
		returnProviderFactureProduct.setReturnProviderFacture(null);

		return returnProviderFactureProduct;
	}

}