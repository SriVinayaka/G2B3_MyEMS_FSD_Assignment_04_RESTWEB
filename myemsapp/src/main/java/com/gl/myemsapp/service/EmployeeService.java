/**
 * 
 */
package com.gl.myemsapp.service;

/**
 * 
 */

import java.util.List;

import com.gl.myemsapp.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public void save(Employee employee);

	public Employee findById(int id);

	public void deleteById(int id);
}