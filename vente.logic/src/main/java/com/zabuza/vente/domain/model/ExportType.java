package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the export_type database table.
 * 
 */
@Entity
@Table(name="export_type")
@NamedQuery(name="ExportType.findAll", query="SELECT e FROM ExportType e")
public class ExportType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=255)
	private String description;

	@Column(nullable=false, length=45)
	private String label;

	@Column(nullable=false, length=45)
	private String name;

	//bi-directional many-to-one association to ExportFacture
	@OneToMany(mappedBy="exportType", fetch=FetchType.EAGER)
	private Set<ExportFacture> exportFactures;

	public ExportType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ExportFacture> getExportFactures() {
		return this.exportFactures;
	}

	public void setExportFactures(Set<ExportFacture> exportFactures) {
		this.exportFactures = exportFactures;
	}

	public ExportFacture addExportFacture(ExportFacture exportFacture) {
		getExportFactures().add(exportFacture);
		exportFacture.setExportType(this);

		return exportFacture;
	}

	public ExportFacture removeExportFacture(ExportFacture exportFacture) {
		getExportFactures().remove(exportFacture);
		exportFacture.setExportType(null);

		return exportFacture;
	}

}