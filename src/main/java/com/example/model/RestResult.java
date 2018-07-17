package com.example.model;

public class RestResult {
	private int idResult;
	private String nameEmployee;
	private String surNameEmployee;
	private String nameTariff;
	private String nameField;
	private Double rate;
	private Double ammount;
	private Double totalPrice;
	private long idEmployee;

	public int getIdResult() {
		return idResult;
	}
	public void setIdResult(int idResult) {
		this.idResult = idResult;
	}
	public String getNameEmployee() {
		return nameEmployee;
	}
	public void setNameEmployee(String nameEmployee) {
		this.nameEmployee = nameEmployee;
	}
	public String getSurNameEmployee() {
		return surNameEmployee;
	}
	public void setSurNameEmployee(String surNameEmployee) {
		this.surNameEmployee = surNameEmployee;
	}
	public String getNameTariff() {
		return nameTariff;
	}
	public void setNameTariff(String nameTariff) {
		this.nameTariff = nameTariff;
	}
	public String getNameField() {
		return nameField;
	}
	public void setNameField(String nameField) {
		this.nameField = nameField;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
		this.totalPrice=rate*ammount;
	}
	public Double getAmmount() {
		return ammount;
	}
	public void setAmmount(Double ammount) {
		this.ammount = ammount;
		this.totalPrice=rate*ammount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
		
	public long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(long idEmployee) {
		this.idEmployee = idEmployee;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ammount == null) ? 0 : ammount.hashCode());
		result = prime * result + (int)idEmployee;
		result = prime * result + idResult;
		result = prime * result + ((nameEmployee == null) ? 0 : nameEmployee.hashCode());
		result = prime * result + ((nameField == null) ? 0 : nameField.hashCode());
		result = prime * result + ((nameTariff == null) ? 0 : nameTariff.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		result = prime * result + ((surNameEmployee == null) ? 0 : surNameEmployee.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
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
		RestResult other = (RestResult) obj;
		if (ammount == null) {
			if (other.ammount != null)
				return false;
		} else if (!ammount.equals(other.ammount))
			return false;
		if (idEmployee != other.idEmployee)
			return false;
		if (idResult != other.idResult)
			return false;
		if (nameEmployee == null) {
			if (other.nameEmployee != null)
				return false;
		} else if (!nameEmployee.equals(other.nameEmployee))
			return false;
		if (nameField == null) {
			if (other.nameField != null)
				return false;
		} else if (!nameField.equals(other.nameField))
			return false;
		if (nameTariff == null) {
			if (other.nameTariff != null)
				return false;
		} else if (!nameTariff.equals(other.nameTariff))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		if (surNameEmployee == null) {
			if (other.surNameEmployee != null)
				return false;
		} else if (!surNameEmployee.equals(other.surNameEmployee))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "RestResult [idResult=" + idResult + ", nameEmployee=" + nameEmployee + ", surNameEmployee="
				+ surNameEmployee + ", nameTariff=" + nameTariff + ", nameField=" + nameField + ", rate=" + rate
				+ ", ammount=" + ammount + ", totalPrice=" + totalPrice + ", idEmployee=" + idEmployee + "]";
	}
	public RestResult(int idResult, String nameEmployee, String surNameEmployee, String nameTariff, String nameField,
			Double rate, Double ammount,long idEmployee) {
		this.idResult = idResult;
		this.nameEmployee = nameEmployee;
		this.surNameEmployee = surNameEmployee;
		this.nameTariff = nameTariff;
		this.nameField = nameField;
		this.rate = rate;
		this.ammount = ammount;
		totalPrice=rate*ammount;
		this.idEmployee=idEmployee;
	}

}
