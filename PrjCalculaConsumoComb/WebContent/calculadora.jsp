<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consumo</title>
</head>
<body>
Verifique o seu consumo aqui:
<br />
<%
	double comb = Double.parseDouble(request.getParameter("qtdeComb"));
	double km = Double.parseDouble(request.getParameter("kmRodados"));	
	double resultado = km/comb;
	out.println(resultado+" km/l");
%>
<br />
<%
	if (resultado < 8.0){	
		out.println("O carro bebe muito!");
	}
%>
</body>
</html>