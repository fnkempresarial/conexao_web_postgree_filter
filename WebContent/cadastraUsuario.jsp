<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastre o usuário</title>
</head>
<body>
<form method="post" action="cadastraUsuarioServlet">
Insira o login
<input type = "text" name="usuario" id="usuario" />
Insira a senha
<input type="password" name="senha" id="senha"/>
<input type="submit" value = "Aperte"/>
</form>


</body>
</html>