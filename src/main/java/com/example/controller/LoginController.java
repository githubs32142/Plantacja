package com.example.controller;

import java.util.List;
import java.util.function.Consumer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value={ "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/addUser", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("admin/addUser");
		modelAndView.addObject("successMessage", "");
		return modelAndView;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByName(user.getName());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("admin/addUser");
			modelAndView.addObject("user", new User());
			List<ObjectError> list = bindingResult.getAllErrors();
			StringBuilder sb= new StringBuilder();
			list.stream().forEach(new Consumer<ObjectError>() {
				@Override
				public void accept(ObjectError t) {
					sb.append(t.getDefaultMessage()).append("\n");
				}
			});
			System.out.println(sb.toString());
			modelAndView.addObject("successMessage", "no");
			modelAndView.addObject("error", sb.toString());
			
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "yes");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("admin/addUser");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/blank", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByName(auth.getName());
		modelAndView.addObject("userName",  user.getName());
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/blank");
		return modelAndView;
	}
	
	@RequestMapping(value="/allUser", method = RequestMethod.GET)
	public ModelAndView allUser(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users",userService.getAll());
		modelAndView.setViewName("admin/allUser");
		return modelAndView;
	}

}
