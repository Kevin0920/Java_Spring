package com.codingdojo.displaydate.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Time {
Date now = new Date();
	
	@RequestMapping("/timeShow")
	public String date(Model model) {
		Date now = new Date();
		model.addAttribute("now", now);
		return "time.jsp";
		
	}
}
