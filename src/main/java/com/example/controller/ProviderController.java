package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Field;
import com.example.model.Provider;
import com.example.service.ProviderService;

@Controller
public class ProviderController {
	
	@Autowired
	ProviderService service;
	
	@RequestMapping(value="/addProvider", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("provider", new Provider());
		modelAndView.setViewName("admin/addProvider");
		return modelAndView;
	}
	
	@RequestMapping(value="/addProvider", method = RequestMethod.POST)
	public ModelAndView saveProvider(@Valid Provider provider,BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		service.addProvider(provider);
		modelAndView.addObject("provider",new Provider());
		modelAndView.setViewName("admin/addProvider");
		return modelAndView;
	}
	@RequestMapping(value="/allProvider", method = RequestMethod.GET)
	public ModelAndView getProvider(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("providers",service.getAll());
		modelAndView.setViewName("admin/allProvider");
		modelAndView.addObject("delete","");
		return modelAndView;
	}
	@RequestMapping(value="/deleteProvider", method = RequestMethod.GET)
	public ModelAndView saveProvider(@RequestParam("id") long id){
		ModelAndView modelAndView = new ModelAndView();
		service.deleteProvider(id);
		modelAndView.addObject("providers",service.getAll());
		modelAndView.addObject("delete","Usunięto pomyślnie");
		modelAndView.setViewName("admin/allProvider"); 
		return modelAndView;
	}
	@RequestMapping(value="/addField", method = RequestMethod.GET)
	public ModelAndView fieldHome(@RequestParam("id") long id){
		ModelAndView modelAndView = new ModelAndView();
	//	modelAndView.addObject("provider", service.findById(id));
		System.out.println(service.findById(id));
		Field f = new Field();
		f.setProvider(service.findById(id));
		modelAndView.addObject("field", f);
		modelAndView.addObject("provider", service.findById(id));
		modelAndView.setViewName("admin/addField");
		return modelAndView;
	}
	@RequestMapping(value="/addField", method = RequestMethod.POST)
	public ModelAndView saveField(@Valid Field field, @RequestParam(value = "idProvider") long idProvider, BindingResult bindingResult){
		ModelAndView modelAndView = new ModelAndView();
		field.setProvider(service.findById(idProvider));
		service.saveField(field);
		modelAndView.addObject("field", new Field(field.getProvider()));
		modelAndView.addObject("provider", field.getProvider());
		modelAndView.setViewName("admin/addField");
		return modelAndView;
	}
	
	@RequestMapping(value="/allField", method = RequestMethod.GET)
	public ModelAndView allField (){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/allField");
		modelAndView.addObject("obj","App");
		modelAndView.addObject("providers",service.getAll());
		return modelAndView;
	}
	
}
