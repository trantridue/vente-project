package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the import_facture_product database table.
 * 
 */
@Entity
@Table(name="import_facture_product")
@NamedQuery(name="ImportFactureProduct.findAll", query="SELECT i FROM ImportFactureProduct i")
public class ImportFactureProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private float price;

	@Column(nullable=false)
	private int quantity;

	//bi-directional many-to-one association to ImportFacture
	@ManyToOne
	@JoinColumn(name="import_facture_id", nullable=false)
	private ImportFacture importFacture;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;

	public ImportFactureProduct() {
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

	public ImportFacture getImportFacture() {
		return this.importFacture;
	}

	public void setImportFacture(ImportFacture importFacture) {
		this.importFacture = importFacture;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}