package com.libertymutual.goforcode.invoicify.models;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
 
@Entity
@Table
public abstract class BillingRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 
	@ManyToOne
	private User createdBy;
	
	@Column(nullable = false)
	private Date createdOn;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	protected abstract double getTotal();

	public Long getId() { 
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
