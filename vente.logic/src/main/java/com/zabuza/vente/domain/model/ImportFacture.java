package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the import_facture database table.
 * 
 */
@Entity
@Table(name="import_facture")
@NamedQuery(name="ImportFacture.findAll", query="SELECT i FROM ImportFacture i")
public class ImportFacture implements Serializable {
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

	@Column(length=1000)
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_date", nullable=false)
	private Date updateDate;

	@Column(name="user_id", nullable=false)
	private int userId;

	//bi-directional many-to-one association to Provider
	@ManyToOne
	@JoinColumn(name="provider_id", nullable=false)
	private Provider provider;

	//bi-directional many-to-one association to ImportFactureProduct
	@OneToMany(mappedBy="importFacture", fetch=FetchType.EAGER)
	private Set<ImportFactureProduct> importFactureProducts;

	public ImportFacture() {
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

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Provider getProvider() {
		return this.provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public Set<ImportFactureProduct> getImportFactureProducts() {
		return this.importFactureProducts;
	}

	public void setImportFactureProducts(Set<ImportFactureProduct> importFactureProducts) {
		this.importFactureProducts = importFactureProducts;
	}

	public ImportFactureProduct addImportFactureProduct(ImportFactureProduct importFactureProduct) {
		getImportFactureProducts().add(importFactureProduct);
		importFactureProduct.setImportFacture(this);

		return importFactureProduct;
	}

	public ImportFactureProduct removeImportFactureProduct(ImportFactureProduct importFactureProduct) {
		getImportFactureProducts().remove(importFactureProduct);
		importFactureProduct.setImportFacture(null);

		return importFactureProduct;
	}

}