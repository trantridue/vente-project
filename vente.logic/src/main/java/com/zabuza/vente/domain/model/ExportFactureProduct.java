package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the export_facture_product database table.
 * 
 */
@Entity
@Table(name="export_facture_product")
@NamedQuery(name="ExportFactureProduct.findAll", query="SELECT e FROM ExportFactureProduct e")
public class ExportFactureProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private float price;

	@Column(nullable=false)
	private int quantity;

	//bi-directional many-to-one association to ExportFacture
	@ManyToOne
	@JoinColumn(name="export_facture_id", nullable=false)
	private ExportFacture exportFacture;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;

	public ExportFactureProduct() {
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

	public ExportFacture getExportFacture() {
		return this.exportFacture;
	}

	public void setExportFacture(ExportFacture exportFacture) {
		this.exportFacture = exportFacture;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}