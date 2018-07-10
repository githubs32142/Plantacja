package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Field;
import com.example.model.Tariff;
import com.example.repository.TariffRepository;

@Service
public class TariffService {

		@Autowired
		TariffRepository repo;
		
		public void save(Tariff t) {
			repo.save(t);
		}
		public void save(Tariff t,Field f) {
			t.getFields().add(f);
			repo.save(t);
		}
		public void addField(Field field, int id) {
			repo.getOne(id).getFields().add(field);
		}
		
		public int getMaxId() {
			return repo.getMaxId();
		}
		
		public List<Tariff> getListTariff(long idField){
			return repo.getTariff(idField);
		}
}
