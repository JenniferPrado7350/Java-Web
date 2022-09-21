<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
	table, th, td { 
		border: 3px solid #ff7783; 
		color: brown;
	}
	td:hover {
		border: 3px solid white;
	}
	body {
		background: pink;
	}
	a {
		text-decoration: none; 
		color: brown;
	}
	button{ 
		background-image: linear-gradient(to right, #ff7783 , #edd2d7); 
		padding: 15px 25px 15px 25px; 
		color: brown;
		font-size: 18px; 
		font-weight: bold;
		border: solid 2px #ff7783;  
		font-family: "Times New Roman", Times, serif;
	}
    .btnComprarMais:hover{ 
	    background-image: linear-gradient(to right, #edd2d7 , #ff7783);  
	    border: solid 2px #fff;    
    }
    .divTitulo{
	    padding: 10px; 
	    border-left: 3px solid #ff7783;
	    color: brown;
    }
    .divTitulo:hover{ 
	    border-left: 3px solid white; 
    }
</style>

<title>Carrinho</title>
</head>
<body>
	<div id="divCarrinho" style="padding: 30px;">
		<c:if test="${not empty sessionScope.listaCarrinho}">
			<br>
			<div class="test"><div class="divTitulo"><h1 style="margin: 10px 0px 10px 0px;">Meu Carrinho:</h1></div></div>
			<br>
			<br>
			<table>
				<tr>
					<th>
						Nome		
					</th>
					<th>
						Preço
					</th>
					<th>
						Operação
					</th>
				</tr>
				<c:forEach var="produto" items="${sessionScope['listaCarrinho']}" 
																varStatus="index">
					<tr>
						<td>
							<a href="/CadastroProduto/carrinho?id=${produto.id}">
								${produto.nome}
							</a>		
						</td>
						<td>
							<a href="/CadastroProduto/carrinho?id=${produto.id}">
								${produto.preco}
							</a>		
						</td>
	 					<td> 
							<a href="/CadastroProduto/removerCarrinho?sequenciaBusca=${index.count-1}">
	 							Remover</a>
	 					</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
			
		<c:if test="${empty sessionScope['listaCarrinho']}">
				Nenhum produto no carrinho .
		</c:if>
		
		<br />
		<a href="/CadastroProduto/buscar-produto.jsp"><button class="btnComprarMais">Continuar Comprando</button></a>
	</div>
</body>
</html>