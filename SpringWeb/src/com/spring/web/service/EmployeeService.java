package com.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.dao.Employee;
import com.spring.web.dao.EmployeeDao;
import com.spring.web.dao.UpdateEmployeeDao;

import java.util.List;

@Service("employeeService")
public class EmployeeService {
	private EmployeeDao employeeDao;
	private UpdateEmployeeDao updateEmployeeDao;

	@Autowired
	public void setUpdateEmployeeDao(UpdateEmployeeDao updateEmployeeDao) {
		this.updateEmployeeDao = updateEmployeeDao;
	}

	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> getEmployees() {
		return employeeDao.employeesDetails();

	}
	
	public boolean create(Employee emp){
		return updateEmployeeDao.create(emp);
	}

}
