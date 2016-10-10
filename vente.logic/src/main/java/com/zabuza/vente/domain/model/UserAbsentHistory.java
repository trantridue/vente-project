package com.zabuza.vente.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_absent_history database table.
 * 
 */
@Entity
@Table(name="user_absent_history")
@NamedQuery(name="UserAbsentHistory.findAll", query="SELECT u FROM UserAbsentHistory u")
public class UserAbsentHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date date;

	@Temporal(TemporalType.DATE)
	@Column(name="date_from", nullable=false)
	private Date dateFrom;

	@Temporal(TemporalType.DATE)
	@Column(name="date_to", nullable=false)
	private Date dateTo;

	@Column(length=255)
	private String description;

	@Column(name="nbr_days", nullable=false)
	private float nbrDays;

	@Column(name="user_id", nullable=false)
	private int userId;

	public UserAbsentHistory() {
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

	public Date getDateFrom() {
		return this.dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return this.dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getNbrDays() {
		return this.nbrDays;
	}

	public void setNbrDays(float nbrDays) {
		this.nbrDays = nbrDays;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}