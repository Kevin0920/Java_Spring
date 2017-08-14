package com.coding.Relationships.controllers;

import java.text.DecimalFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding.Relationships.models.License;
import com.coding.Relationships.models.Person;
import com.coding.Relationships.services.LicenseService;
import com.coding.Relationships.services.PersonService;

@Controller 
public class LicenseCon {

	private final PersonService personService;
	private final LicenseService licenseService;
	
	public LicenseCon(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	public String licenseNumber() {
        int numPeople = licenseService.allLicenses().size();
        DecimalFormat df = new DecimalFormat("000000");
        String licenseNum = df.format(numPeople);
        return licenseNum;
    }
	
	@RequestMapping("/licenses/new")
	public String addLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> people = personService.findAll();
		model.addAttribute("people", people);
		return "addLicense";
	}
	
	@PostMapping("/licenses/new")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "addLicense";
		}else {
			license.setNumber(licenseNumber());
			licenseService.createLicense(license);
			return "redirect:/persons/" + license.getPerson().getId();
		}
		
	}
	
	@RequestMapping("/licenses/{id}")
	public String findLicense(@PathVariable("id") Long id, Model model) {
		License foundLicense = licenseService.getLicense(id);
		System.out.println("License: " + foundLicense);
		model.addAttribute("foundLicense", foundLicense);
		return "person";
	}
	
	
	
}
