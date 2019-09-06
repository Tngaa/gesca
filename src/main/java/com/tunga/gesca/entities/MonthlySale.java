package com.tunga.gesca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "monthly_sales")
public class MonthlySale extends AbstractEntity {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_annual_sale", nullable = false)
	private AnnualSale annualSale;

	@Column(name = "month")
	private Integer month;

	@Column(name = "sales")
	private Float sales;

	@Column(name = "social_charges")
	private Float socialCharges;

	@Column(name = "professional_fees")
	private Float professionalFees;

	public MonthlySale() {
		super();
	}

	public MonthlySale(AnnualSale annualSale, Integer month, Float sales, Float socialCharges, Float professionalFees) {
		super();
		this.annualSale = annualSale;
		this.month = month;
		this.sales = sales;
		this.socialCharges = socialCharges;
		this.professionalFees = professionalFees;
	}

	public AnnualSale getAnnualSale() {
		return annualSale;
	}

	public void setAnnualSale(AnnualSale annualSale) {
		this.annualSale = annualSale;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Float getSales() {
		return sales;
	}

	public void setSales(Float sales) {
		this.sales = sales;
	}

	public Float getSocialCharges() {
		return socialCharges;
	}

	public void setSocialCharges(Float socialCharges) {
		this.socialCharges = socialCharges;
	}

	public Float getProfessionalFees() {
		return professionalFees;
	}

	public void setProfessionalFees(Float professionalFees) {
		this.professionalFees = professionalFees;
	}

}