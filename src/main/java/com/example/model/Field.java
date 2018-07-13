package com.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pola")
public class Field implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7226798556105858977L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pola")
	private long id;
	
	@Column(name = "nazwa_pola")
	private String fieldName;
	
	@Column(name = "powierzchnia")
	private Double area;
	
	@ManyToOne
    @JoinColumn(name="id_firmy", nullable=false)
    private Provider provider;
	 
	
	@ManyToMany
	@JoinTable(name = "taryfy_pola", joinColumns = @JoinColumn(name = "id_pola"), inverseJoinColumns = @JoinColumn(name = "id_taryfy"))
 	List<Tariff> tariffs= new ArrayList<>();
	
	@OneToMany(mappedBy="field")
	List<Result> results = new ArrayList<>();
    
	public List<Tariff> getTariffs() {
		return tariffs;
	}

	public void setTariffs(List<Tariff> tariffs) {
		this.tariffs = tariffs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getfieldName() {
		return fieldName;
	}

	public void setfieldName(String field) {
		this.fieldName = field;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((provider == null) ? 0 : provider.hashCode());
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		result = prime * result + ((tariffs == null) ? 0 : tariffs.hashCode());
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
		Field other = (Field) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (id != other.id)
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		if (tariffs == null) {
			if (other.tariffs != null)
				return false;
		} else if (!tariffs.equals(other.tariffs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Field [id=" + id + ", fieldName=" + fieldName + ", area=" + area + ", provider=" + provider
				+ ", tariffs=" + tariffs + ", results=" + results + "]";
	}

	public Field(String fieldName, Double area, Provider provider, List<Tariff> tariffs, List<Result> results) {
		this.fieldName = fieldName;
		this.area = area;
		this.provider = provider;
		this.tariffs = tariffs;
		this.results = results;
	}

	public Field() {
	}

	

}
