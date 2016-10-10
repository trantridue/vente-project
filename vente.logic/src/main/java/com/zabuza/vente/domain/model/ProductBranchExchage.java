package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the product_branch_exchage database table.
 * 
 */
@Entity
@Table(name="product_branch_exchage")
@NamedQuery(name="ProductBranchExchage.findAll", query="SELECT p FROM ProductBranchExchage p")
public class ProductBranchExchage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date date;

	@Column(length=255)
	private String description;

	@Column(name="destination_branch_id", nullable=false)
	private int destinationBranchId;

	@Column(nullable=false)
	private int quantity;

	@Column(name="source_branch_id", nullable=false)
	private int sourceBranchId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	private Date updateDate;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_id", nullable=false)
	private Product product;

	public ProductBranchExchage() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getDestinationBranchId() {
		return this.destinationBranchId;
	}

	public void setDestinationBranchId(int destinationBranchId) {
		this.destinationBranchId = destinationBranchId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSourceBranchId() {
		return this.sourceBranchId;
	}

	public void setSourceBranchId(int sourceBranchId) {
		this.sourceBranchId = sourceBranchId;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}