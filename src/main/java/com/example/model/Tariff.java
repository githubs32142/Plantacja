package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.example.model.Field;;
@Entity
@Table(name = "Taryfy")
public class Tariff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_taryfy")
	private int id;
	
	@Column(name = "nazwa_taryfy")
	private String nameTariff;
	
	@Column(name = "Stawka")
	private Double rate;
	
	@ManyToMany(mappedBy = "tariffs")
	 List<Field> fields= new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameTariff() {
		return nameTariff;
	}

	public void setNameTariff(String nameTariff) {
		this.nameTariff = nameTariff;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + id;
		result = prime * result + ((nameTariff == null) ? 0 : nameTariff.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
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
		Tariff other = (Tariff) obj;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (id != other.id)
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
		return true;
	}

	public Tariff(String nameTariff, Double rate, List<Field> fields) {
		this.nameTariff = nameTariff;
		this.rate = rate;
		this.fields = fields;
	}

	public Tariff() {
		// TODO Auto-generated constructor stub
	}
	
	

}
