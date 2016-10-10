package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the export_product_return database table.
 * 
 */
@Entity
@Table(name="export_product_return")
@NamedQuery(name="ExportProductReturn.findAll", query="SELECT e FROM ExportProductReturn e")
public class ExportProductReturn implements Serializable {
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
	@JoinColumn(name="old_export_facture_id", nullable=false)
	private ExportFacture exportFacture1;

	//bi-directional many-to-one association to ExportFacture
	@ManyToOne
	@JoinColumn(name="export_facture_id", nullable=false)
	private ExportFacture exportFacture2;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;

	public ExportProductReturn() {
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

	public ExportFacture getExportFacture1() {
		return this.exportFacture1;
	}

	public void setExportFacture1(ExportFacture exportFacture1) {
		this.exportFacture1 = exportFacture1;
	}

	public ExportFacture getExportFacture2() {
		return this.exportFacture2;
	}

	public void setExportFacture2(ExportFacture exportFacture2) {
		this.exportFacture2 = exportFacture2;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}