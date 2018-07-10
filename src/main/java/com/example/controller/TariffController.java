package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Provider;
import com.example.model.Tariff;
import com.example.service.ProviderService;

@Controller
public class TariffController {
	
	@Autowired
	ProviderService service;
	
	@RequestMapping(value="/addTariff", method = RequestMethod.GET)
	public ModelAndView addTarif(){
		ModelAndView modelAndView = new ModelAndView();
		List<Provider> list = service.getAll();
		modelAndView.addObject("providers", list);
		modelAndView.addObject("tariff", new Tariff());
		modelAndView.setViewName("admin/addTariff");
		return modelAndView;
	}
	@RequestMapping(value="/allTariff", method = RequestMethod.GET)
	public ModelAndView allTariff(){
		ModelAndView modelAndView = new ModelAndView();
		List<Provider> list = service.getAll();
		modelAndView.addObject("providers", list);
		modelAndView.addObject("tariff", new Tariff());
		modelAndView.setViewName("admin/allTariff");
		return modelAndView;
	}
}
