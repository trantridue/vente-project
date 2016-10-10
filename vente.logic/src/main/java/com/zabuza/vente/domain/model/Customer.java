package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name="customer")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_day")
	private Date birthDay;

	@Column(nullable=false, length=32)
	private String code;

	@Column(length=255)
	private String description;

	@Column(length=255)
	private String email;

	@Column(nullable=false, length=255)
	private String name;

	@Column(length=16)
	private String phone;

	@Column(nullable=false)
	private byte sex;

	//bi-directional many-to-one association to ExportFacture
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	private Set<ExportFacture> exportFactures;

	public Customer() {
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

	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public byte getSex() {
		return this.sex;
	}

	public void setSex(byte sex) {
		this.sex = sex;
	}

	public Set<ExportFacture> getExportFactures() {
		return this.exportFactures;
	}

	public void setExportFactures(Set<ExportFacture> exportFactures) {
		this.exportFactures = exportFactures;
	}

	public ExportFacture addExportFacture(ExportFacture exportFacture) {
		getExportFactures().add(exportFacture);
		exportFacture.setCustomer(this);

		return exportFacture;
	}

	public ExportFacture removeExportFacture(ExportFacture exportFacture) {
		getExportFactures().remove(exportFacture);
		exportFacture.setCustomer(null);

		return exportFacture;
	}

}