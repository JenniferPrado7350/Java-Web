<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar contato</title>
</head>
<body>
	<form action="adicionar" method="POST">
		Nome: <input type="text" name="nome"/> <br />
		Endere�o: <input type="text" name="endereco"/> <br />
		E-mail: <input type="text" name="email"/> <br />
		Data de nascimento: <input type="text" name="dtnascimento"/> <br />
		<input type="submit" value="Cadastrar"/> <br />
	</form>
</body>
</html>