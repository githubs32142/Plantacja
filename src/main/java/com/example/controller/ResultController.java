package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Provider;
import com.example.model.Tariff;
import com.example.service.EmployeeService;
import com.example.service.ProviderService;

@Controller
public class ResultController {

	@Autowired
	ProviderService service;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/addResult", method = RequestMethod.GET)
	public ModelAndView addResult(){
		ModelAndView modelAndView = new ModelAndView();
		List<Provider> list = service.getAll();
		modelAndView.addObject("providers", list);
		modelAndView.addObject("employees",employeeService.getAll());
		modelAndView.addObject("tariff", new Tariff());
		modelAndView.setViewName("admin/addResult");
		return modelAndView;
	}
	
	@RequestMapping(value="/allResult", method = RequestMethod.GET)
	public ModelAndView getResult(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/allResult");
		return modelAndView;
	}
	

	
}
