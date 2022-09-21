<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Rendimento do veículo</title>
</head>
<body>
Calcule o rendimento do seu carro:
<form action="calculadora.jsp" method="POST">
	Quantidade de combustivel consumido: <input type="text" name="qtdeComb"/>
	<br />
	Quantidade de km rodados: <input type="text" name="kmRodados"/>
	<input type="submit" value="Calcular"/>
</form>
</body>
</html>