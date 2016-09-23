package com.zc.service;

import java.util.List;

import com.zc.dao.EmployeeDao;
import com.zc.entity.Employee;

public class EmployeeService {
	private EmployeeDao employeeDao;
	public void setEmployeeDao(EmployeeDao employeeDao){
		this.employeeDao=employeeDao;
	}
	public List<Employee> getAll(){
		return employeeDao.getAll();
	}
}
