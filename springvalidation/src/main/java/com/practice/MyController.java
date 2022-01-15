package com.practice;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.practice.entities.LoginData;

@Controller
public class MyController {
	
	@GetMapping("/form")
	public String openForm(Model m) {
		m.addAttribute("loginData", new LoginData());
		System.out.println("login form");
		return "form";
	}
	
//	handler for process form
	@PostMapping("/process")
	/*
	 * @valid called as validator it will be triggered and field will be validate
	 * based on annotation that is inside bean and return error inside bindingResult
	 */	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData,BindingResult result)
	{
		System.out.println(loginData);
		if(result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		System.out.println(loginData);
//		data process
		return "success";
		
	}

}
