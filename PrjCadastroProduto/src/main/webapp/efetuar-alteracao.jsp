<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.uel.produtos.Produto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Efetuar Alteracao</title>
</head>
<body>

	<%
		Produto produto = (Produto)request.getAttribute("produto");
	
	%>

	<form action="efetuarAlteracao" method="POST">
		Nome: <input type="text" name="nome" value="<%=produto.getNome()%>"/> <br />
		Preco: <input type="text" name="preco" value="<%=produto.getPreco()%>"/> <br />
		Quantidade: <input type="text" name="quantidade" value="<%=produto.getQuantidade()%>"/> <br />
		<input type="hidden" name=id value="<%=produto.getId()%>"/> <br />
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>