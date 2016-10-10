package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the return_provider_facture_product database table.
 * 
 */
@Entity
@Table(name="return_provider_facture_product")
@NamedQuery(name="ReturnProviderFactureProduct.findAll", query="SELECT r FROM ReturnProviderFactureProduct r")
public class ReturnProviderFactureProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private float price;

	@Column(nullable=false)
	private int quantity;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	@JoinColumn(name="provider_id", nullable=false)
	private Provider provider;

	//bi-directional many-to-one association to ReturnProviderFacture
	@ManyToOne
	@JoinColumn(name="return_provider_facture_id", nullable=false)
	private ReturnProviderFacture returnProviderFacture;

	public ReturnProviderFactureProduct() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public ReturnProviderFacture getReturnProviderFacture() {
		return this.returnProviderFacture;
	}

	public void setReturnProviderFacture(ReturnProviderFacture returnProviderFacture) {
		this.returnProviderFacture = returnProviderFacture;
	}

}