<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Cotação</h1>
	<form action='resp.jsp' method='post'>
		Preço Unitário(Dólar): 
		<input type='number' name='preço_uni'>
		<br>
		Descrição:
		<input type='text' name='descricao'>
		<br>
		Quantidade:
		<input type='number' name='quantidade'>
		<br>
		<input type='submit' value='calcular'/>
	
	</form>
	

</body>
</html>