<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ include file="/header.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de Produtos</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Produto</th>
				<th>Preço</th>
				<th>Comprar</th>
				<c:if test="${usuarioWeb.logado }">
					<th>Edita</th>
					<th>Deleta</th>
				</c:if>
			</tr>
		</thead>	
		<tbody>
			<c:forEach items="${produtoList }" var="produto">
				<tr>
					<td>${produto.id }</td>
					<td>${produto.nome }</td>
					<td>${produto.descricao }</td>
					<td><img src="<c:url value="/produtos/${produto.id }/imagem"/>" width="50" height="50" /></td>
					<td>${produto.preco }</td>
					<td align="center">
						<form action="<c:url value="/carrinho"/>" method="POST">
							<input type="hidden" name="item.produto.id" value="${produto.id }"/>
							<input class="qtde" name="item.quantidade" value="1"/>
							<button type="submit"><img src="/vraptor-blank-project/imgs/add.png"></button>
						</form>
					</td>
					<c:if test="${usuarioWeb.logado }">
						<td align="center">
							<a href="<c:url value="/produtos/${produto.id }"/>">
								<img src="/vraptor-blank-project/imgs/edit.png" /></a>
						</td>
						<td align="center">
							<form action="<c:url value="/produtos/${produto.id }"/>" 
								method="POST">
								<button class="link" name="_method" value="DELETE">
									<img src="/vraptor-blank-project/imgs/del.png"></button>
							</form>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>