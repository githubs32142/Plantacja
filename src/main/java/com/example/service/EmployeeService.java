package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	public void save(Employee employee) {
		repository.save(employee);
	}
	
	public List<Employee> getAll() {
		return repository.findAll();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public Employee getById(int id) {
		//System.out.println(repository.findOne(id).toString());
		return repository.findOne(id);
	}
}
