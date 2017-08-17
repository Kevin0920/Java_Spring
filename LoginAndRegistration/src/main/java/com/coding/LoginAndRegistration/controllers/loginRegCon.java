package com.coding.LoginAndRegistration.controllers;


import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding.LoginAndRegistration.models.User;
import com.coding.LoginAndRegistration.services.UserService;
import com.coding.LoginAndRegistration.validator.UserValidator;

@Controller
public class loginRegCon {
	private UserService userService;
	private UserValidator userValidator;
	
    
    public loginRegCon(UserService userService, UserValidator userValidator) {
    this.userService = userService;
    this.userValidator = userValidator;
    }
    
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        String username = principal.getName();
        Date now = new Date();  

        List<User> users = userService.allUsers();       
        User currentUser = userService.findByUsername(username);
        
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("users", users);
        model.addAttribute("Date", now);
        
                     
        	return "homePage";
    		}
//    
    
	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user) {
		return "landingPage";
	}
    
    
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
	    if (result.hasErrors()) {
	        return "landingPage";
	    }
	    if (userService.allUsers().size()==0) {
		    userService.saveUserWithAdminRole(user);
	    }
	    else {
		    userService.saveWithUserRole(user);
		}
	    
	    return "redirect:/login";
	    }
	
	// route for admin
	
	@RequestMapping("/admin")
	 public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        model.addAttribute("users", userService.allUsers());
        return "adminPage";
    }

	
	@RequestMapping("/login")
	    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, @Valid @ ModelAttribute("user") User user) {
	        if(error != null) {
	            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
	        }
	        if(logout != null) {
	            model.addAttribute("logoutMessage", "Logout Successfull!");
	        }
	        return "landingPage";
	    }
	
	@RequestMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			userService.destroyService(id);
			return "redirect:/adminPage";			
	}
	
}
