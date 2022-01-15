package com.practice;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value = "/about",method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about handler .....");
		model.addAttribute("name", "umar");
		model.addAttribute("currentDate", new Date().toString());
		return "about";
//		about.html
	}
	
//	Handling Iteration
	@GetMapping("/example-loop")
	public String iterationHandler(Model model) {
		List<String> names = List.of("umar","Azhar","Subham","Akhlaque");
		model.addAttribute("names", names);
	
		return "iteration";
		
	}
	
//	Handler for Conditional Statements
	@GetMapping("/condition")
	public String conditionHandler(Model model) {
		System.out.println("conditional handler executed..");
		model.addAttribute("isActive",false);
		model.addAttribute("gender", "M");
		List<Integer> list = List.of(1);
		model.addAttribute("myList", list);
		return "condition";
	}
	
//	handler for thymeleafe fragements
	@GetMapping("/service")
	public String serviceHandler(Model model) {
		model.addAttribute("title", "i like the Technologies");
		model.addAttribute("subtitle", LocalDate.now().toString());
		return "service";
	}
	
//	for new about
	@GetMapping("/newabout")
	public String newAbout() {
		return "aboutnew";
	}

}
