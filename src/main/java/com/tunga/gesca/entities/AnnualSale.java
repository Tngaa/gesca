package com.tunga.gesca.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "annual_sales")
public class AnnualSale extends AbstractEntity {

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;

	@Column(name = "year", nullable = false)
	private Integer year;

	@Column(name = "sales")
	private Float sales;

	@Column(name = "social_charges")
	private Float socialCharges;

	@Column(name = "professional_fees")
	private Float professionalFees;

//	@JsonInclude(value = Include.NON_EMPTY)
	@OneToMany(mappedBy = "annualSale", fetch = FetchType.LAZY)
	private List<MonthlySale> monthlySales;

	public AnnualSale() {
		super();
	}

	public AnnualSale(User user, Integer year, Float sales, Float socialCharges, Float professionalFees) {
		super();
		this.user = user;
		this.year = year;
		this.sales = sales;
		this.socialCharges = socialCharges;
		this.professionalFees = professionalFees;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
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

	public List<MonthlySale> getMonthlySales() {
		return monthlySales;
	}

	public void setMonthlySales(List<MonthlySale> monthlySales) {
		this.monthlySales = monthlySales;
	}
}