package com.zc.service;

import java.util.List;

import com.zc.dao.DepartmentDao;
import com.zc.entity.Department;

public class DepartmentService {
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao){
		this.departmentDao=departmentDao;
	}
	//调用dao查询
	public List<Department> getAll(){
		return departmentDao.getAll();
	}
}
