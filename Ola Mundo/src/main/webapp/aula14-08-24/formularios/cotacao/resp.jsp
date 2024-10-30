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
		double p_dolar = Double.parseDouble(request.getParameter("preco_uni"));
		String descricao = request.getParameter("descricao");
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		
		double cotacaoDolar= 5.48;
		
		double preco_uni_reais = p_dolar*cotacaoDolar;
		double preco_total_reais = preco_uni_reais*quantidade;

	%>
	
	
	<p><strong>Descrição:</strong> <%=descricao %> </p>
	<p><strong>Preço unitário em reais:</strong> <%=preco_uni_reais %></p>
	<p><strong>Preço total em reais: </strong> <%=preco_total_reais %> </p>
	
	

	

</body>
</html>