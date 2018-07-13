package com.example.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="id_pola", nullable=false)
	private Field field;
	
	@ManyToOne
	@JoinColumn(name="id_taryfy", nullable=false)
	private Tariff tariff;
	
	
}
