<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="user" method="post" action="addUser">
		用户名:<form:input path="username"/><br>
		密码:<form:input path="password"/><br>
		邮箱:<form:input path="email"/><br>
		<input type="submit" value="提交"/><br>
	</form:form>
</body>
</html>