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
		PessoaDao dao = new PessoaDao();
		Pessoa p = new Pessoa();
		p.setIdpessoa(Integer.parseInt(request.getParameter("idpessoa")));
		p.setNome(request.getParameter("nome"));
		p.setTelefone(request.getParameter("telefone"));
		p.setEmail(request.getParameter("email"));
		p.setCidade(request.getParameter("cidade"));
		
		
	%>
</body>
</html>