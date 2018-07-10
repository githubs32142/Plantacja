package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="firma")
public class Provider implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 196599632012845842L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_firmy")
	private long id;
	
	@Column(name = "nazwa_firmy")
	private String nameCompany;
	
	@Column(name = "Miasto")
	private String city;
	
	@Column(name = "Ulica")
	private String street;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany(mappedBy="provider")
	List<Field> fields = new ArrayList<>();
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((fields == null) ? 0 : fields.hashCode());
		result = prime * result + (int)id;
		result = prime * result + ((nameCompany == null) ? 0 : nameCompany.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Provider other = (Provider) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (fields == null) {
			if (other.fields != null)
				return false;
		} else if (!fields.equals(other.fields))
			return false;
		if (id != other.id)
			return false;
		if (nameCompany == null) {
			if (other.nameCompany != null)
				return false;
		} else if (!nameCompany.equals(other.nameCompany))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Provider [id=" + id + ", nameCompany=" + nameCompany + ", city=" + city + ", street=" + street
				+ ", type=" + type + ", fields=" + fields + "]";
	}

	public Provider(String nameCompany, String city, String street, String type, List<Field> fields) {
		this.nameCompany = nameCompany;
		this.city = city;
		this.street = street;
		this.type = type;
		this.fields = fields;
	}

	public Provider() {
		
		// TODO Auto-generated constructor stub
	}
	

}
