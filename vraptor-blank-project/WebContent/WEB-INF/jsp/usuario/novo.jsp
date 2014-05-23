<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Novos Usuarios</title>
</head>
<body>
	<form id="usuariosForm" action="<c:url value="/usuario"/>" method="POST">
		<fieldset>
			<legend>Criar novo usuário</legend>
			
			<label for="nome">Nome:</label>
			<input id="nome" type="text" name="usuario.nome" value="${usuario.nome }"/>
			
			<label for="login">Login:</label>
			<input id="login" type="text" name="usuario.login" value="${usuario.login }"/>
			
			<label for="senha">Senha:</label>
			<input id="senha" type="password" name="usuario.senha"/>
			
			<label for="confirmacao">Confirme a senha:</label>
			<input id="confirmacao" type="password" equalTo="#senha"/>
						
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
	
	<script type="text/javascript" src="<c:url 
		value="/javascripts/validaUsuario.js"/>"></script>
</body>
</html>