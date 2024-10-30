<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Quantidade de pessoas</h1>
	<form action='resp.jsp' method="post">
		Quantidade de Homens:
		<input type='number' name='homens'>
		<br>
		Quantide de mulheres:
		<input type='number' name='mulheres'>
		<br>
		Quantidade de Crianças: 
		<input type='number' name='criancas'>
		<br>
		
		<input type='submit' value='Calcular quantidade'>
		
 	</form>

</body>
</html>