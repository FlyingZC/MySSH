package com.zc.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.zc.entity.Employee;
import com.zc.service.DepartmentService;
import com.zc.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements RequestAware,
ModelDriven<Employee>,Preparable{
    private static final long serialVersionUID = 1L;
    private EmployeeService employeeService;
	private DepartmentService departmentService;
	private Map<String, Object> request;
	private Integer id;//删除员工从页面传来的id
	
	public void setEmployeeService(EmployeeService employeeService){
		this.employeeService=employeeService;
	}
	public Integer getId()
    {
        return id;
    }
    public void setDepartmentService(DepartmentService departmentService ){
		this.departmentService=departmentService;
	}
	//查询所有员工信息
	public String list(){
		request.put("employees", employeeService.getAll());
		return "list";
	}
	
	//不使用ajax方式删除删除
	
	/*public String delete(){
		employeeService.delete(id);
		return "success";
	}*/
	
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
	//处理ajax请求
	private InputStream inputStream;
	public InputStream getInputStream(){
		return inputStream;
	}
	public String delete() {
		try {
		    Integer nid = this.getModel().getId();
			employeeService.delete(nid);
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
		//return "ajax-success";
		return "success";
	}
	
	
	//跳转到修改页面,实际上就是跳转到input页面
	public String update(){
	    Employee e = employeeService.find(getModel().getId());
	    //request.put("employee",e );
	    request.put("department", departmentService.getAll());
        return "input";
	}
	
	//---------添加操作emp-save.action-------
	private Employee model=new Employee();
	//查询部门信息,跳转到添加员工页面
	public String input(){
	    request.put("department", departmentService.getAll());
	    return "input";
	}
	//实现Prepare接口中的方法
    public void prepare() throws Exception
    {
        
    }
    //实现ModelDriven接口中的方法
    public Employee getModel()
    {
        return model;
    }
	
    public String save(){
        model.setCreateTime(new Date());
        employeeService.saveOrUpdate(model);
        return "success";
    }
	
}
