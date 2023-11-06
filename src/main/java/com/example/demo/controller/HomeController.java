package com.example.demo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.Dao.StudentDao;
import com.example.demo.model.Student;

import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    String fun(Model model) {
        Student st = new Student();
        System.out.println("Data in st object before form: " + st);

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
	
	@RequestMapping("/delete/{roll}")
	ModelAndView deleteStudent(@PathVariable("roll") int roll) {
	    System.out.println("Data in st object after form: " + roll);
	    
	    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	    StudentDao dao = (StudentDao) context.getBean("d");

	    // Retrieve the student by roll number and delete it
	    Student student = dao.getStudentByRoll(roll);
	    if (student != null) {
	        dao.deleteStudent(student);
	    }

	    List<Student> stdl = dao.getAllStd();
	    ModelAndView mv = new ModelAndView("test2.html");
	    mv.addObject("stdl", stdl);
	    return mv;
	}
	
	

    @RequestMapping(value = "/update/{roll}", method = RequestMethod.GET)
    ModelAndView showUpdateForm(@PathVariable("roll") int roll) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao dao = (StudentDao) context.getBean("d");

        Student student = dao.getStudentByRoll(roll);
        ModelAndView mv = new ModelAndView("update.html");
        mv.addObject("obj", student);
        return mv;
    }

    @RequestMapping(value = "/update/{roll}", method = RequestMethod.POST)
    ModelAndView updateStudent(@ModelAttribute("obj") Student st1, @PathVariable("roll") int roll) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDao dao = (StudentDao) context.getBean("d");

        // Retrieve the student by roll number
        Student existingStudent = dao.getStudentByRoll(roll);
        
        if (existingStudent != null) {
            // Update the existing student data
            existingStudent.setName(st1.getName());
            existingStudent.setMarks(st1.getMarks());
            dao.updateStudent(existingStudent);
        }

        List<Student> stdl = dao.getAllStd();
        ModelAndView mv = new ModelAndView("test2.html");
        mv.addObject("stdl", stdl);
        return mv;
    }
}