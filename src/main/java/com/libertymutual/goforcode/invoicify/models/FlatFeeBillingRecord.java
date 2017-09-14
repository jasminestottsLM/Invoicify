package com.libertymutual.goforcode.invoicify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FlatFeeBillingRecord extends BillingRecord {
	 
	@Column(nullable = false)
	private double amount;

	@Override
	protected double getTotal() {
		return amount;		
	}  

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
