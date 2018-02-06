<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加员工</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  <body>
	<s:form action="emp-save.action" method="post" >
		<s:textfield name="lastName" label="lastName"></s:textfield>
		<s:textfield name="employee.email" label="邮箱"></s:textfield>
		<s:select list="#request.department"
			listKey="id" listValue="departmentName"
			name="department.id" label="部门">
		</s:select>
		<s:textfield name="" label="描述"></s:textfield>
		<s:submit></s:submit>
		<s:debug></s:debug>
	</s:form>  
  </body>
</html>
