package com.coding.Relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.coding.Relationships.models.Person;

import com.coding.Relationships.services.PersonService;

@Controller
public class PersonCon {
	
	private final PersonService personService;

	
	public PersonCon(PersonService personService) {
		this.personService = personService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/persons/new")
	public String addPerson(@ModelAttribute("person") Person person) {
		return "addPerson";
	}
	
	@PostMapping("/persons/new")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "addPerson";
		}else {
			personService.addPerson(person);
			return "redirect:/";
		}
	}
	
	
	@RequestMapping("/persons/{id}")
	public String personDetails(@PathVariable("id")Long id, Model model) {
		model.addAttribute("person", personService.findPerson(id));
		
		return "person";
	}
	
}
