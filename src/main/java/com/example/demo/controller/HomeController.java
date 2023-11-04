package com.example.demo.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Dao.StudentDao;
import com.example.demo.model.Student;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	String fun(Model model)
	{
		Student st = new Student();
		System.out.println("Data in st  object before form : "+ st);
		
		model.addAttribute("obj", st);
		return "test.html";
	}
	
	@RequestMapping("/reg")
	ModelAndView fun2(@ModelAttribute("obj") Student st1) {
		System.out.println("Data in st object after form :"+st1);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao dao = (StudentDao) context.getBean("d");
		if(dao.saveStd(st1))
		{
			System.out.println("data saved");
		}
		List<Student> stdl = dao.getAllStd();
		ModelAndView mv = new ModelAndView("test2.html");
		mv.addObject("ob",st1);
		mv.addObject("stdl", stdl);
		return mv;
	}
	

}
