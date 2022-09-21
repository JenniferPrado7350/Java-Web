<%@page import="br.uel.Morador"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de moradores</title>
</head>
<body>
<%
	LinkedList<Morador> listaMoradores = new LinkedList<Morador>();
	for (int i = 0; i < 10; i++){
		Morador morador = new Morador();
		morador.setNome("morador "+i);
		morador.setNumeroApto(i+1);
		listaMoradores.add(morador);
	}
%>
<table>
	<tr>
		<td>Nome do morador</td>
		<td>Número do apartamento</td>
	</tr>
<%
	for (int j = 0; j < 7; j++){
%>
	<tr>
		<td><%=listaMoradores.get(j).getNome() %></td>
		<td><%=listaMoradores.get(j).getNumeroApto() %></td>
	</tr>
<%
	} 
%>
</table>
</body>
</html>