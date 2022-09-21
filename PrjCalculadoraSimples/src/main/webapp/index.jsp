<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculadora</title>
</head>
<body>
Escolha a operação:
<form action="OperationResult.jsp" method="POST">
	
<select name="operations" id="cars">
  <option value="sum">Soma</option>
  <option value="subtraction">Subtração</option>
  <option value="multiplication">Multiplicação</option>
  <option value="division">Divisão</option>
</select>
	<br />
	<h3>Digite o Primeiro Numero:</h3> <input type="text" name="number1"/>
	<br />
	<h3>Digite o Segundo Numero:</h3> <input type="text" name="number2"/>
	<br />
	Resultado: <input type="text" name="result"/>
	<input type="submit" value="Calcular"/>
</form>
</body>
</html>