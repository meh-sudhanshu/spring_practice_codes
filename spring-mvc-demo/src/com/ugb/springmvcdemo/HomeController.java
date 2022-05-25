package com.ugb.springmvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String showMyPage() {		
		return "myView";
	}

	
	@RequestMapping("/showMyForm")
	public String showMyForm() {
		
		 return "showForm";
	}
	
//	@RequestMapping("/welcome")
//	public String welcomeStudent() {
//		return "welcome";
//	}
	
	@RequestMapping("/welcome")
	public String processData(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		
		name = name.toUpperCase();
		
		model.addAttribute("studentName", name);
		
		
		return "welcome";
	}
	
}
