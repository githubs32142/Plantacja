package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Field;
import com.example.model.Provider;
import com.example.repository.FieldRepository;
import com.example.repository.ProviderRepository;

@Service
public class ProviderService {
	
	@Autowired
	ProviderRepository provider;
	@Autowired
	FieldRepository field;
	
	public void addProvider(Provider p) {
		provider.save(p);
	}
	public List<Provider> getAll(){
		return provider.findAll();
	}
	public void deleteProvider(long id) {
		provider.delete(id);
	}
	public Provider findById(long id) {
		return provider.findOne(id);
	}
	public void saveField(Field f) {
		field.save(f);
	}
	
}
