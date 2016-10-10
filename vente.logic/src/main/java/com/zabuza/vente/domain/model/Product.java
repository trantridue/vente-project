package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@Table(name="product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=32)
	private String code;

	@Column(length=1000)
	private String description;

	@Column(nullable=false, length=255)
	private String name;

	@Column(nullable=false)
	private float price;

	//bi-directional many-to-one association to ExportFactureProduct
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private Set<ExportFactureProduct> exportFactureProducts;

	//bi-directional many-to-one association to ExportProductReturn
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private Set<ExportProductReturn> exportProductReturns;

	//bi-directional many-to-one association to ImportFactureProduct
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private Set<ImportFactureProduct> importFactureProducts;

	//bi-directional many-to-one association to ProductBranchExchage
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private Set<ProductBranchExchage> productBranchExchages;

	//bi-directional many-to-one association to ProductDeviation
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private Set<ProductDeviation> productDeviations;

	//bi-directional many-to-one association to ReturnProviderFactureProduct
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private Set<ReturnProviderFactureProduct> returnProviderFactureProducts;

	//bi-directional many-to-one association to SaleProduct
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private Set<SaleProduct> saleProducts;

	public Product() {
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

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Set<ExportFactureProduct> getExportFactureProducts() {
		return this.exportFactureProducts;
	}

	public void setExportFactureProducts(Set<ExportFactureProduct> exportFactureProducts) {
		this.exportFactureProducts = exportFactureProducts;
	}

	public ExportFactureProduct addExportFactureProduct(ExportFactureProduct exportFactureProduct) {
		getExportFactureProducts().add(exportFactureProduct);
		exportFactureProduct.setProduct(this);

		return exportFactureProduct;
	}

	public ExportFactureProduct removeExportFactureProduct(ExportFactureProduct exportFactureProduct) {
		getExportFactureProducts().remove(exportFactureProduct);
		exportFactureProduct.setProduct(null);

		return exportFactureProduct;
	}

	public Set<ExportProductReturn> getExportProductReturns() {
		return this.exportProductReturns;
	}

	public void setExportProductReturns(Set<ExportProductReturn> exportProductReturns) {
		this.exportProductReturns = exportProductReturns;
	}

	public ExportProductReturn addExportProductReturn(ExportProductReturn exportProductReturn) {
		getExportProductReturns().add(exportProductReturn);
		exportProductReturn.setProduct(this);

		return exportProductReturn;
	}

	public ExportProductReturn removeExportProductReturn(ExportProductReturn exportProductReturn) {
		getExportProductReturns().remove(exportProductReturn);
		exportProductReturn.setProduct(null);

		return exportProductReturn;
	}

	public Set<ImportFactureProduct> getImportFactureProducts() {
		return this.importFactureProducts;
	}

	public void setImportFactureProducts(Set<ImportFactureProduct> importFactureProducts) {
		this.importFactureProducts = importFactureProducts;
	}

	public ImportFactureProduct addImportFactureProduct(ImportFactureProduct importFactureProduct) {
		getImportFactureProducts().add(importFactureProduct);
		importFactureProduct.setProduct(this);

		return importFactureProduct;
	}

	public ImportFactureProduct removeImportFactureProduct(ImportFactureProduct importFactureProduct) {
		getImportFactureProducts().remove(importFactureProduct);
		importFactureProduct.setProduct(null);

		return importFactureProduct;
	}

	public Set<ProductBranchExchage> getProductBranchExchages() {
		return this.productBranchExchages;
	}

	public void setProductBranchExchages(Set<ProductBranchExchage> productBranchExchages) {
		this.productBranchExchages = productBranchExchages;
	}

	public ProductBranchExchage addProductBranchExchage(ProductBranchExchage productBranchExchage) {
		getProductBranchExchages().add(productBranchExchage);
		productBranchExchage.setProduct(this);

		return productBranchExchage;
	}

	public ProductBranchExchage removeProductBranchExchage(ProductBranchExchage productBranchExchage) {
		getProductBranchExchages().remove(productBranchExchage);
		productBranchExchage.setProduct(null);

		return productBranchExchage;
	}

	public Set<ProductDeviation> getProductDeviations() {
		return this.productDeviations;
	}

	public void setProductDeviations(Set<ProductDeviation> productDeviations) {
		this.productDeviations = productDeviations;
	}

	public ProductDeviation addProductDeviation(ProductDeviation productDeviation) {
		getProductDeviations().add(productDeviation);
		productDeviation.setProduct(this);

		return productDeviation;
	}

	public ProductDeviation removeProductDeviation(ProductDeviation productDeviation) {
		getProductDeviations().remove(productDeviation);
		productDeviation.setProduct(null);

		return productDeviation;
	}

	public Set<ReturnProviderFactureProduct> getReturnProviderFactureProducts() {
		return this.returnProviderFactureProducts;
	}

	public void setReturnProviderFactureProducts(Set<ReturnProviderFactureProduct> returnProviderFactureProducts) {
		this.returnProviderFactureProducts = returnProviderFactureProducts;
	}

	public ReturnProviderFactureProduct addReturnProviderFactureProduct(ReturnProviderFactureProduct returnProviderFactureProduct) {
		getReturnProviderFactureProducts().add(returnProviderFactureProduct);
		returnProviderFactureProduct.setProduct(this);

		return returnProviderFactureProduct;
	}

	public ReturnProviderFactureProduct removeReturnProviderFactureProduct(ReturnProviderFactureProduct returnProviderFactureProduct) {
		getReturnProviderFactureProducts().remove(returnProviderFactureProduct);
		returnProviderFactureProduct.setProduct(null);

		return returnProviderFactureProduct;
	}

	public Set<SaleProduct> getSaleProducts() {
		return this.saleProducts;
	}

	public void setSaleProducts(Set<SaleProduct> saleProducts) {
		this.saleProducts = saleProducts;
	}

	public SaleProduct addSaleProduct(SaleProduct saleProduct) {
		getSaleProducts().add(saleProduct);
		saleProduct.setProduct(this);

		return saleProduct;
	}

	public SaleProduct removeSaleProduct(SaleProduct saleProduct) {
		getSaleProducts().remove(saleProduct);
		saleProduct.setProduct(null);

		return saleProduct;
	}

}