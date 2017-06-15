<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="<%=request.getContextPath() %>/upload.do" method="post" enctype="multipart/form-data">
		用户名:<input type="text" name="userName"/><br />
		上传单文件:<input type="file" name="file"><br />
		<input type="submit" name="提交" /><br />
	</form>
	<hr>
	<form action="<%=request.getContextPath() %>/uploads.do" method="post" enctype="multipart/form-data">
		用户名:<input type="text" name="userName"/><br />
		上传多文件:<input type="file" name="files" multiple="multiple"><br />
		<input type="submit" name="提交" /><br />
	</form>
</body>
</html>