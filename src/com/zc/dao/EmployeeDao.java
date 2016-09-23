package com.zc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zc.entity.Employee;

public class EmployeeDao {
	private SessionFactory sessionFactory;
	//查询所有员工
	public List<Employee> getAll(){
		String hql="from Employee";
		/*List<Employee> l=getSession().createQuery(hql).list();
		for(Employee e:l){
			System.out.println(e);
		}*/
		return getSession().createQuery(hql).list();
		//return l;
	}
	//
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	//获取session
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
}
