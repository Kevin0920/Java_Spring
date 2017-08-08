package com.codingdojo.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Date {
	
	@RequestMapping("/dateShow")
	public String date(Model model) {
		
		String now = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		model.addAttribute("now", now);		
		return "date.jsp";
	}
}
