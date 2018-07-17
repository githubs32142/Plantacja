package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Field;
import com.example.model.Result;
import com.example.model.Tariff;
import com.example.repository.ResultRepository;

@Service
public class ResultService {
	
	@Autowired
	ResultRepository repository;
	
	public void save(Result result) {
		repository.save(result);
	}
	public void save(Result result,Field field,Tariff tarif) {
		result.setField(field);
		result.setTariff(tarif);
		repository.save(result);
	}
	public int getMaxId() {
		return repository.getMaxId();
	}
	public List<Result> findResultBetween(Date startDate,Date endDate){
		return repository.getResultBeetwen(startDate,endDate);
	}
}
