package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.model.*;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Wyniki")
public class Result implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8165063461518998014L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_wyniku")
	private int id;
	
	@Column(name="ilosc")
	private double amount;
	
	@Column(name="date")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="id_pola", nullable=false)
	private Field field;
	
	@ManyToOne
	@JoinColumn(name="id_taryfy", nullable=false)
	private Tariff tariff;
	
	@ManyToMany(mappedBy="results")
	List<Employee> employees= new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public Tariff getTariff() {
		return tariff;
	}

	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + id;
		result = prime * result + ((tariff == null) ? 0 : tariff.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Result other = (Result) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (id != other.id)
			return false;
		if (tariff == null) {
			if (other.tariff != null)
				return false;
		} else if (!tariff.equals(other.tariff))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", amount=" + amount + ", date=" + date + ", field=" + field + ", tariff=" + tariff
				+ ", employees=" + employees + "]";
	}

	public Result(double amount, Date date, Field field, Tariff tariff, List<Employee> employees) {
		this.amount = amount;
		this.date = date;
		this.field = field;
		this.tariff = tariff;
		this.employees = employees;
	}

	public Result() {
	}
	
	
}
