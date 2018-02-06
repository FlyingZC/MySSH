package com.zc.dao;

import java.util.List;

import com.zc.entity.Department;
import com.zc.entity.Employee;

public class DepartmentDao extends BaseDao{
	public List<Department> getAll(){
		String hql="from Department";
		List<Department> l=getSession().createQuery(hql).list();
		for(Department e:l){
			System.out.println(e);
		}
		//return getSession().createQuery(hql).list();
		return l;
	}
}
