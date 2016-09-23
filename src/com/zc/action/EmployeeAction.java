package com.zc.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zc.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware{
	private EmployeeService employeeService;
	private Map<String, Object> request;
	
	public void setEmployeeService(EmployeeService employeeService){
		this.employeeService=employeeService;
	}
	public String list(){
		request.put("employees", employeeService.getAll());
		return "list";
	}
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
}
