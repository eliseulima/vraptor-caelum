<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formul�rio de Produto</title>
</head>
<body>
	<form id="produtosForm" action="<c:url value="/produtos"/>" method="POST">
		<fieldset>
			<legend>Adicionar Produto</legend>
			
			<label for="nome">Nome:</label>
			<input id="nome" type="text" name="produto.nome" value="${produto.nome }"/>
			
			<label for="descricao">Descri��o:</label>
			<textarea id="descricao" name="produto.descricao">${produto.descricao }</textarea>
			
			<label for="preco">Pre�o:</label>
			<input id="preco" type="text" name="produto.preco" value="${produto.preco }"/>
			
			<button type="submit">Enviar</button>
		</fieldset>
	</form>
	
	<script type="text/javascript" src="<c:url 
		value="/javascripts/validaProduto.js"/>"></script>
</body>
</html>