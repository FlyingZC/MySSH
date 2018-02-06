package com.zc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//Dao的基类,抽取公共代码
public class BaseDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	//获取session
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
}
