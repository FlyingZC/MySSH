package com.zc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zc.entity.Employee;

public class EmployeeDao extends BaseDao{
	//查询所有员工
	public List<Employee> getAll(){
		//String hql="from Employee";
		//迫切左外连接
		String hql="from Employee e LEFT OUTER JOIN FETCH e.department";
		/*
		 * 迫切左外连接打印的sql
		 * Hibernate: 
    select
        employee0_.ID as ID1_1_0_,
        department1_.ID as ID1_0_1_,
        employee0_.LAST_NAME as LAST_NAM2_1_0_,
        employee0_.EMAIL as EMAIL3_1_0_,
        employee0_.BIRTH as BIRTH4_1_0_,
        employee0_.CREATE_TIME as CREATE_T5_1_0_,
        employee0_.DEPARTMENT_ID as DEPARTME6_1_0_,
        department1_.DEPARTMENT_NAME as DEPARTME2_0_1_ 
    from
        SSH_EMPLOYEE employee0_ 
    left outer join
        SSH_DEPARTMENT department1_ 
            on employee0_.DEPARTMENT_ID=department1_.ID
    Employee [id=1, lastName=smith, email=123@qq.com, birth=2016-09-22 21:29:53.0, createTime=2016-09-22 21:30:01.0, department=Department [id=1, departmentName=人事部]]
		 * */
		List<Employee> l=getSession().createQuery(hql).list();
		for(Employee e:l){
			System.out.println(e);
		}
		//return getSession().createQuery(hql).list();
		return l;
	}
	
	public Employee find(Integer id){
	    List<Employee> e = getSession().createQuery("from Employee e where e.id=?").setInteger(0, id).list();
	    return e.get(0);
	}
	
	public void delete(Integer id){
		String hql="delete from Employee e where e.id=?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	public void saveOrUpdate(Employee employee){
	    getSession().saveOrUpdate(employee);
	}
	
}
