package com.techmunna.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techmunna.dao.DataAccess;
import com.techmunna.model.Employee;



@Controller
public class StudentController {
	
	
	@RequestMapping("delete")
	public ModelAndView deleteStudent(int id) {
		ModelAndView mv= new ModelAndView();

		//set 1: call the delete method present in database in DataAccess layer
		DataAccess da =new DataAccess();
		da.delete(id);
		
		//step2: redirect user to display.jsp with remaining now reflect in table
        ArrayList <Employee> al= da.getAllEmployee();
		
		mv.addObject("lst", al);
		mv.setViewName("display.jsp");
		
		return mv;
		
		
	}
	
	
	
	@RequestMapping("update")
	public ModelAndView updateEmployee(HttpServletRequest request) {
		
		//1. read the data  from register.jsp page
		ModelAndView mv=new ModelAndView();
		
		int i=Integer.parseInt(request.getParameter("tid")) ;
		
		String n=request.getParameter("tbName");
		String g= request.getParameter("tbgender");
		String d= request.getParameter("tbdob");
		String e=request.getParameter("tbEmail");
		
		String p=request.getParameter("tbphone");
		
		Employee e1= new Employee (i, n, g, d, e, p);
		
		
		//2. update the value in DB
		DataAccess da= new DataAccess();
		
		//3.redirect user to edit from regster.jsp with update Values;
		da.update(e1);
        ArrayList <Employee> al=da.getAllEmployee();
		
		mv.addObject("lst",al);
		mv.setViewName("display.jsp");
		
		return mv;
	}
	
	@RequestMapping("edit")
	public ModelAndView displayEditForm(int id) {
		
		
		ModelAndView mv= new ModelAndView();
		// Setp 1 : retrive the old data from DB
	    //step 2: redirect to user edit form [register.jsp] to display the old data
		
		DataAccess  da=new DataAccess();
		Employee stu= da.getEmployeeById(id);
		
		mv.addObject("student",stu);
		
		mv.setViewName("register.jsp");
		
		
		return mv;
	}
	
	@RequestMapping(value="CRUD",params="Show")
	public ModelAndView showAllStudent() {
		ModelAndView mv=new ModelAndView();
		DataAccess da=new DataAccess();
		
		ArrayList <Employee> al=da.getAllEmployee();
		
		mv.addObject("lst",al);
		mv.setViewName("display.jsp");
		
		return mv;
		
	}
	@RequestMapping(value="CRUD", params="Register")
	public ModelAndView gotoRegister() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("register.jsp");
		
		return mv;
	}
   
    @RequestMapping("reg")
	public ModelAndView insertStudent(HttpServletRequest request)
	{
    	String n=request.getParameter("tbName");
		String g= request.getParameter("tbgender");
		String d= request.getParameter("tbdob");
		String e=request.getParameter("tbEmail");
		
		String p=request.getParameter("tbphone");
		
		Employee e1=new Employee(n,g,d,e,p);
		e1.setName(n);
		e1.setGender(g);
		e1.setDob(d);
		e1.setEmail(e);
		e1.setPhone(p);
		
		
		
		//JDBC Connection code:
		DataAccess dao= new DataAccess();
		
		dao.insert(e1);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("register.jsp");
		mv.addObject("res", "inserted in Database");
		
		return mv;
	}
}