package com.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.dao.Employee;
import com.spring.web.service.EmployeeService;

@Controller
public class EmployeeController {
	/*
	 * @RequestMapping("/") public String showHome(HttpSession session){
	 * 
	 * session.setAttribute("name", "Anita"); return "home"; }
	 */

	/*
	 * @RequestMapping("/") public ModelAndView showHome1(){ ModelAndView mv =
	 * new ModelAndView("home"); Map<String,Object> model= mv.getModel();
	 * model.put("name", "<b>Sumanth</b>");
	 * 
	 * 
	 * return mv;
	 * 
	 * }
	 */

	private EmployeeService employeeService;

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping("/employees")
	public String showEmployees(Model model) {

		List<Employee> emplist = employeeService.getEmployees();

		model.addAttribute("name", emplist);

		return "employees";
	}

	/*@RequestMapping("/createemployee")
	public String createEmployee() {

		return "createemployee";
	}*/
	/*@RequestMapping(value="/test",method=RequestMethod.GET)
	public String showTest(Model model,@RequestParam("id")String id){
		System.out.println("id is: "+id);
		return "home";
	}*/
	@RequestMapping("/createemployee")
	public String createEmployee(Model model) {
		
		model.addAttribute("employee", new Employee());

		return "createemployee";
	}
	
	/*@RequestMapping( value="/docreate",method=RequestMethod.POST)
	public String doCreate(Model model, Employee employee) {
		boolean b = employeeService.create(employee);
		if(b){
		return "employeecreated";
		}else{
			return "employeenotcreated";
		}
	}*/
	
	@RequestMapping( value="/docreate",method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Employee employee,BindingResult result) {
		boolean b = false;
		if(result.hasErrors()){
			System.out.println("form is not validated");
			List<ObjectError> errors=result.getAllErrors();
			for(ObjectError error :errors){
				System.out.println(error);
			}
		}else{
		 b = employeeService.create(employee);
		}
		if(b){
		return "employeecreated";
		}else{
			return "employeenotcreated";
		}
	}
}
