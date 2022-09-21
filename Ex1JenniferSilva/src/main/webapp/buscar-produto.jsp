<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
	table, th, td { border: 1px solid black; }
</style>
<title>Buscar Produto</title>
</head>
<body>
	<form action="buscar">
		Digite o nome do produto: 
		<input type="text" name="nomeProduto" />
		<br />
		<input type="submit" value="Buscar" />
	</form>
	<br />
	
	<c:if test="${not empty sessionScope.listaBuscados}">
		Lista de buscas recentes:
		<table>
			<tr>
				<th>
					Termo de busca		
				</th>
				<th>
					Operação
				</th>
			</tr>
			<c:forEach var="produto" items="${sessionScope['listaBuscados']}" 
															varStatus="index">
				<tr>
					<td>
						<a href="/CadastroProduto/buscar?nomeProduto=${produto}">
							${produto}
						</a>		
					</td>
					<td>
						<a href="/CadastroProduto/removerBusca?sequenciaBusca=${index.count-1}">
							Remover</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
		
	<c:if test="${empty sessionScope['listaBuscados']}">
			Nenhuma busca recente.
	</c:if>
	
</body>
</html>