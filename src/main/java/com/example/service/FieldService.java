package com.example.service;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.FieldRepository;
import com.example.repository.TariffRepository;
import com.example.model.Field;
import com.example.model.Tariff;

@Service
public class FieldService {
	@Autowired
	FieldRepository field;
	@Autowired
	TariffRepository tariff;
	
	public List<Field> findByIdProvider(long idProvider){
		return field.findByIdProvider(idProvider);
	}
	public Field findOneById(long id) {
		return field.findById(id);
	}
	public void deleteField(long id) {

		field.delete(id);
		
	}
	public List<Field> getAll(){
		return field.findAll();
	}
	public void saveTarrif(Tariff tariff, long id) {
			Field f = new Field();
			f=findOneById(id);
			f.getTariffs().add(tariff);
			field.save(f);
	}
}
