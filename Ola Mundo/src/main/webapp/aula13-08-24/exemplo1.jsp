<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file= "menu.jsp" %>
	<%@ include file= "topo.jsp" %>
		
	<%!
		//declaração
		public double media(double a, double b){
			return (a+b)/2.0;
	}
	%>

	<%
		//scriptlet
		int a = 1;
		int b = 2;
		int c = a+b;
		//out.print(c)
		
	%>
	
	<div style= 'font-size:140pt'>
		<%= c %>
		<br/>
		<%= media(a,b) %>
	</div>

</body>
</html>