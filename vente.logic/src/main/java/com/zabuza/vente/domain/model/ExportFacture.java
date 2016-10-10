package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the export_facture database table.
 * 
 */
@Entity
@Table(name="export_facture")
@NamedQuery(name="ExportFacture.findAll", query="SELECT e FROM ExportFacture e")
public class ExportFacture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false)
	private float bonus;

	@Column(name="branch_id", nullable=false)
	private int branchId;

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

	@Column(name="user_id", nullable=false)
	private int userId;

	//bi-directional many-to-one association to CustomerPayHistory
	@OneToMany(mappedBy="exportFacture", fetch=FetchType.EAGER)
	private Set<CustomerPayHistory> customerPayHistories;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;

	//bi-directional many-to-one association to ExportType
	@ManyToOne
	@JoinColumn(name="export_type_id", nullable=false)
	private ExportType exportType;

	//bi-directional many-to-one association to ExportFactureProduct
	@OneToMany(mappedBy="exportFacture", fetch=FetchType.EAGER)
	private Set<ExportFactureProduct> exportFactureProducts;

	//bi-directional many-to-one association to ExportProductReturn
	@OneToMany(mappedBy="exportFacture1", fetch=FetchType.EAGER)
	private Set<ExportProductReturn> exportProductReturns1;

	//bi-directional many-to-one association to ExportProductReturn
	@OneToMany(mappedBy="exportFacture2", fetch=FetchType.EAGER)
	private Set<ExportProductReturn> exportProductReturns2;

	public ExportFacture() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBonus() {
		return this.bonus;
	}

	public void setBonus(float bonus) {
		this.bonus = bonus;
	}

	public int getBranchId() {
		return this.branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
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

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Set<CustomerPayHistory> getCustomerPayHistories() {
		return this.customerPayHistories;
	}

	public void setCustomerPayHistories(Set<CustomerPayHistory> customerPayHistories) {
		this.customerPayHistories = customerPayHistories;
	}

	public CustomerPayHistory addCustomerPayHistory(CustomerPayHistory customerPayHistory) {
		getCustomerPayHistories().add(customerPayHistory);
		customerPayHistory.setExportFacture(this);

		return customerPayHistory;
	}

	public CustomerPayHistory removeCustomerPayHistory(CustomerPayHistory customerPayHistory) {
		getCustomerPayHistories().remove(customerPayHistory);
		customerPayHistory.setExportFacture(null);

		return customerPayHistory;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ExportType getExportType() {
		return this.exportType;
	}

	public void setExportType(ExportType exportType) {
		this.exportType = exportType;
	}

	public Set<ExportFactureProduct> getExportFactureProducts() {
		return this.exportFactureProducts;
	}

	public void setExportFactureProducts(Set<ExportFactureProduct> exportFactureProducts) {
		this.exportFactureProducts = exportFactureProducts;
	}

	public ExportFactureProduct addExportFactureProduct(ExportFactureProduct exportFactureProduct) {
		getExportFactureProducts().add(exportFactureProduct);
		exportFactureProduct.setExportFacture(this);

		return exportFactureProduct;
	}

	public ExportFactureProduct removeExportFactureProduct(ExportFactureProduct exportFactureProduct) {
		getExportFactureProducts().remove(exportFactureProduct);
		exportFactureProduct.setExportFacture(null);

		return exportFactureProduct;
	}

	public Set<ExportProductReturn> getExportProductReturns1() {
		return this.exportProductReturns1;
	}

	public void setExportProductReturns1(Set<ExportProductReturn> exportProductReturns1) {
		this.exportProductReturns1 = exportProductReturns1;
	}

	public ExportProductReturn addExportProductReturns1(ExportProductReturn exportProductReturns1) {
		getExportProductReturns1().add(exportProductReturns1);
		exportProductReturns1.setExportFacture1(this);

		return exportProductReturns1;
	}

	public ExportProductReturn removeExportProductReturns1(ExportProductReturn exportProductReturns1) {
		getExportProductReturns1().remove(exportProductReturns1);
		exportProductReturns1.setExportFacture1(null);

		return exportProductReturns1;
	}

	public Set<ExportProductReturn> getExportProductReturns2() {
		return this.exportProductReturns2;
	}

	public void setExportProductReturns2(Set<ExportProductReturn> exportProductReturns2) {
		this.exportProductReturns2 = exportProductReturns2;
	}

	public ExportProductReturn addExportProductReturns2(ExportProductReturn exportProductReturns2) {
		getExportProductReturns2().add(exportProductReturns2);
		exportProductReturns2.setExportFacture2(this);

		return exportProductReturns2;
	}

	public ExportProductReturn removeExportProductReturns2(ExportProductReturn exportProductReturns2) {
		getExportProductReturns2().remove(exportProductReturns2);
		exportProductReturns2.setExportFacture2(null);

		return exportProductReturns2;
	}

}