/**
 * 
 */
package com.gl.myemsapp.service.implementation;

/**
 * 
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.myemsapp.entity.Employee;
import com.gl.myemsapp.repository.EmployeeRepository;
import com.gl.myemsapp.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {

		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public Employee findById(int employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

}