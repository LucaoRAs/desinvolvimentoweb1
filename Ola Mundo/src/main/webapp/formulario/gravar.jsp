<%@page import="org.libertas.Pessoa"%>
<%@page import="org.libertas.PessoaDao"%>
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

		Pessoa p = new Pessoa();
		p.setIdpessoa(Integer.parseInt(request.getParameter("id")));
		PessoaDao pdao = new PessoaDao();
		
		pdao.excluir(p);
		
	%>
	<a href="index.jsp">ok<a/>
</body>
</html>