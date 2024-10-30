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
		String time1 = request.getParameter("time1");
		int gol1 = Integer.parseInt(request.getParameter("gol1"));
				
		String time2 = request.getParameter("time2");
		int gol2 = Integer.parseInt(request.getParameter("gol2"));	
	
	
		if (gol1 > gol2){
			out.print(time1 + " ganhou de " + gol1 + " X " + gol2);
		}else if (gol1<gol2){
			out.print(time2 + " ganhou de " + gol2 + " X " + gol1);
		}else{
			out.print("Empate:" + time1 + " " +  gol1 + " X " + gol2 + " " + time2);}
				
	
	%>
</body>
</html>