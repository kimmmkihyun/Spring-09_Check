package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@RequestMapping(value ="form" , method = RequestMethod.GET)   // url�� �Է��ؼ� ��û(get���)
	public String form() { 
		
		return "form";
	}
	
	@RequestMapping(value ="form" , method = RequestMethod.POST)  // type="submit" ������ ��û
	public String form2(@ModelAttribute("stu") @Valid Student s, BindingResult result) {
		
		System.out.println(s.getName());
		System.out.println(s.getId());
		
		String page = "result";
		System.out.println(result.hasErrors());   
		//error �߻� ��������  false
		//error �߻� ������ true
		
		if(result.hasErrors()) { //������ ���� ����
			page = "form";
		}
		
		return page;
	}
	
	
	
	
}
