/**
 * 
 */
package com.gl.myemsapp.controller;

/**
 * 
 */

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gl.myemsapp.entity.Employee;
import com.gl.myemsapp.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> employees = employeeService.findAll();

		theModel.addAttribute("employees", employees);

		return "list-employees";
	}
	
    @RequestMapping("/displayEmployeeForm")
    public String addEmployee_Step1(Model theModel) {

        Employee employee = new Employee();

        theModel.addAttribute("employee", employee);

        return "employee-form";
    }    
	
    
    @PostMapping("/save")
    public String saveEmployee(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
        @RequestParam("lastName") String lastName, @RequestParam("email") String email,
        @RequestParam("country") String country) {

      System.out.println("Employee ID ->" + id);

      Employee employeeObj = null;
      if (id == 0) {

        employeeObj = new Employee(firstName, lastName, email, country);
        System.out.println("Add Employee Scenario");
      } else {

    	  employeeObj = employeeService.findById(id);
    	  
    	  employeeObj.setFirstName(firstName);
    	  employeeObj.setLastName(lastName);
    	  employeeObj.setEmail(email);
    	  employeeObj.setCountry(country);    
    	  
        System.out.println("Update Employee Scenario");
      }

      // Save/Update the employee
      employeeService.save(employeeObj);

      // use a redirect to 'employees-listing'
      return "redirect:/employees/list";
    }         
    
    
    @RequestMapping("/displayEmployeeForm_Update")
    public String updateEmployee_Step1(
        @RequestParam("employeeId") int employeeId,
            Model theModel) {

        Employee employee = employeeService.findById(employeeId);

        // set 'employee' as a model attribute to pre-populate the form
        theModel.addAttribute("employee", employee);

        // send over to our form
        return "employee-form";   
    }  
    
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("employeeId") int employeeId) {

        // delete the employee
        employeeService.deleteById(employeeId);

        // redirect to 'employees-listing'
        return "redirect:/employees/list";
    } 
    
    
    @RequestMapping(value = "/403")
    public ModelAndView handleAccessDeniedError(Principal user) {

      ModelAndView model = new ModelAndView();

      if (user != null) {
        model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
      } else {
        model.addObject("msg", "You do not have permission to access this page!");
      }

      model.setViewName("authorization-error-403");
      return model;
    }  
    
}