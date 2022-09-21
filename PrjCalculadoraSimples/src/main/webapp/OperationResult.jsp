<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
</head>
<body>
Resultado da Operação:
<br />
<%
	double number1 = Double.parseDouble(request.getParameter("number1"));
	double number2 = Double.parseDouble(request.getParameter("number2"));	
	String operation = request.getParameter("operations");
	double result = 0;
	
	switch (operation) {
	  case "sum":
		  result = number1 + number2;
	    break;
	  case "subtraction":
		  result = number1 - number2;
	    break;
	  case "multiplication":
		  result = number1 * number2;
	    break;
	  case "division":
		  result = number1 / number2;
	    break;
	  default:
	    result = 0;
	}
	
	out.println(result);
%>
<br />
</body>
</html>