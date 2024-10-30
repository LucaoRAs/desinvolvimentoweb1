<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Dopósito</h1>
	<div> 
		<%
		double poupanca = 1000.00;
		double jurosMes = poupanca * (0.7/100);
		int tempoMes = 5;
		
		double rendimento = jurosMes*tempoMes + poupanca;
		
		out.print(poupanca + ", Rendeu " + jurosMes + " em" + tempoMes + "meses. Saldo:"  + rendimento);
		
		%>
	</div>	
</body>
</html>