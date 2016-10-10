package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sale_type database table.
 * 
 */
@Entity
@Table(name="sale_type")
@NamedQuery(name="SaleType.findAll", query="SELECT s FROM SaleType s")
public class SaleType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	public SaleType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}