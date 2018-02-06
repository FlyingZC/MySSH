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
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="srcipts/jquery-1.9.1.min.js">
		$(function(){
			//1.点击delete时,弹出确定要删除xx的信息吗.
			//若确定执行删除,不确定,取消
			$(".delete").click(function(){
				var flag=confirm("确定要删除信息吗");
				var lastName=$(this).next(":hidden").val();
				if(flag){
				//使用ajax方式删除
				var delDr=$(this).parent().parent();
				var url=this.href;
				var args={"time":new Date()};
					$.post(url,args,function(data){
						//若data返回值为1,提示删除成功,把当前行删除
						if(data=="1"){
							alert("删除成功");
							delDr.remove();
						}else{
						//若返回值不为1,提示删除失败
							alert("删除失败!");						
						}
						
					});
				}
				//2.取消超链接的默认行为
				return false;
			});
			
		});
	</script>
  </head>
  
  <body>
	<h4>Employee List page</h4>
	<s:if test="#request.employees==null||#request.employees.size()==0">
		没有任何员工信息
	</s:if>
	<s:else>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>id</td>
				<td>lastname</td>
				<td>email</td>
				<td>birth</td>
				<td>createtime</td>
				<td>dept</td>
				<td>操作</td>
			</tr>
			<s:iterator value="#request.employees">
				<tr>
					<td>${id }</td>
					<td>${lastName}</td>
					<td>${email }</td>
					<td>${birth }</td>
					<td>${createTime }</td>
					<td>${department.departmentName }</td>
					<td>
						<s:a action="emp-delete.action?id=%{id}">删除</s:a>
						<s:a action="emp-update.action?id=%{id}">修改</s:a>
					</td>
					<input type="hidden" value="${lastName}"/>
				</tr>
			</s:iterator>
		</table>
		<a href="emp-input.action">添加员工信息</a>	
	</s:else>
  </body>
</html>
