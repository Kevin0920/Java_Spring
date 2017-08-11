package com.codingdojo.GroupLanguagesData.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.GroupLanguagesData.models.Language;
import com.codingdojo.GroupLanguagesData.service.LanguageService;

@Controller
public class Languages {
	private final LanguageService languageService;
	public Languages(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@RequestMapping("/languages")
	public String languages(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index";
	}
	
	@PostMapping("/language/new")
	public String newLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
            return "index";
        }else{
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
	}
	
    @RequestMapping("/languages/{index}")
    public String findLanguage(Model model, @PathVariable("index") int index) {
    			Language language = languageService.find(index);
    			if (language != null) {
	            model.addAttribute("language", language);
	            return "language";
    			} else {
    				return "redirect:/languages";
    			}
    }
	 @RequestMapping("/languages/edit/{id}")
	    public String edit(@PathVariable("id") int id, Model model, @ModelAttribute("language") Language language) {
	        Language language1 = languageService.find(id);
	        if (language1 != null){
	            model.addAttribute("language", language1);
	            return "edit";
	        }else{
	            return "redirect:/languages";
	        }
	    }
	 @PostMapping("/languages/update/{id}")
	    public String update(@PathVariable("id") int id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit";
	        }else{
	            languageService.update(id, language);
	            return "redirect:/languages";
	        }
	    }
	 @RequestMapping("/languages/delete/{id}")
	    public String delete(@PathVariable("id") int id) {
	        languageService.delete(id);
	        return "redirect:/languages";
	    }
	 
	
	
}