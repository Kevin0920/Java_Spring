package com.coding.DojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.DojosNinjas.models.Dojo;
import com.coding.DojosNinjas.models.Ninja;
import com.coding.DojosNinjas.services.DojoService;
import com.coding.DojosNinjas.services.NinjaService;


@Controller
public class DojosCon {
	private DojoService dojoService;
	private NinjaService ninjaService;
	
	public DojosCon(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo";
	}
	
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "newDojo";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/ninjas/new")
	public String newDojo(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.findDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja";
	}
	
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja";
		}else {
			// when create the new ninja will redirect to the dojoPage
			String route = "redirect:/dojos/" + ninja.getDojo().getId();
			ninjaService.createNinja(ninja);
			return route;
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String dojoDetail(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findOneDojo(id);
		// list of students info, belong to one dojo
		List<Ninja> ninjas = ninjaService.dojoNinja();
		model.addAttribute("dojo", dojo);
		model.addAttribute("ninjas", ninjas);
		return "dojoPage";
	}
	
	
	
	
	
	
	
}
