<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> Tabela Fibonaci</h1>
	<div>
	<%
		int a = 1;
		int b = 1;
		
		out.print("<div>" + a +  "</div>");
		out.print("<div>" + b +  "</div>");

		
		for(int i=3; i <= 21; i++){
			int proximo = a + b;
			out.print("<div>" + proximo +  "</div>");
			a = b;
			b = proximo;
			
		}
	%>
</div>
</body>
</html>