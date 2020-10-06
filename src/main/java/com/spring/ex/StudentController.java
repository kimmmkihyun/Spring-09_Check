package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@RequestMapping(value ="form" , method = RequestMethod.GET)   // url에 입력해서 요청(get방식)
	public String form() { 
		
		return "form";
	}
	
	@RequestMapping(value ="form" , method = RequestMethod.POST)  // type="submit" 눌러서 요청
	public String form2(@ModelAttribute("stu") @Valid Student s, BindingResult result) {
		
		System.out.println(s.getName());
		System.out.println(s.getId());
		
		String page = "result";
		System.out.println(result.hasErrors());   
		//error 발생 안했으면  false
		//error 발생 했으면 true
		
		if(result.hasErrors()) { //문제가 있을 경우면
			page = "form";
		}
		
		return page;
	}
	
	
	
	
}
