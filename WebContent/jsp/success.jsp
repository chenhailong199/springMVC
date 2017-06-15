<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" style="text/css" href="<%=request.getContextPath()%>/statics/css/main.css" />
</head>
<body>
	username----->${username }<br>
	password----->${password }<br>
	<h4>用户列表</h4>
	<c:forEach items="${studentlist }" var="list">
		${list.stuName }--${list.stuAge}--${list.stuCity}--${list.gradeId }<br/>
	</c:forEach>
	<a href="addUser.do">添加用户</a>
</body>
</html>