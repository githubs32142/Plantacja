package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Employee;
import com.example.model.User;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@RequestMapping(value={ "/addEmployee"}, method = RequestMethod.GET)
	public ModelAndView addEmployee(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/addEmployee");
		modelAndView.addObject("successMessage", "");
		modelAndView.addObject("employee", new Employee());
		return modelAndView;
	}
	
	@RequestMapping(value={ "/addEmployee"}, method = RequestMethod.POST)
	public ModelAndView save(@Valid Employee employee){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/addEmployee");
		if(!employee.getName().isEmpty() && !employee.getSurName().isEmpty()) {
			modelAndView.addObject("successMessage", "yes");
			service.save(employee);
		}
		else {
			modelAndView.addObject("successMessage", "no");
			modelAndView.addObject("error", "Brak wprowadzaonych danych");
		}
		modelAndView.addObject("employee", new Employee());
		return modelAndView;
	}
	
	@RequestMapping(value= {"/allEmployee"}, method=RequestMethod.GET)
	public ModelAndView allEmployyes() {
		ModelAndView modelAndView= new ModelAndView();
		modelAndView.addObject("employees",service.getAll());
		modelAndView.setViewName("admin/allEmployee");
		return modelAndView;
	}
}
