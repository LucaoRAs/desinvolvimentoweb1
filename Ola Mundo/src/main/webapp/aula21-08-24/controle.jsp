<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	String user = request.getParameter("user");
	String pwd = request.getParameter("pwd");
	
	if((user.equals("admin")) && (pwd.equals("123"))){
		response.sendRedirect("admin.jsp");
	}else if((user.equals("ze")) && (pwd.equals("123"))){
		response.sendRedirect("normal.jsp");
	}
	
	else{
		response.sendRedirect("invalido.jsp");
	}
	
	
	
	%>
</body>
</html>