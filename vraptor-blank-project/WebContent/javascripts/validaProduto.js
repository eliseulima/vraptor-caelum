$(function() {
	$("#produtosForm").validate({
		rules : {
			"produto.nome" : { 
				required : true, minLength : 3 
			}, 
			"produto.descricao" : {
				required : true, maxLength : 40 
			},
			"produto.preco" : {
				required : true, min : 0 
			},
		},
		messages : {
			"produto.nome" : {
				required : "Nome � obrigat�rio",
				minLength : "Nome precisa ter mais de 3 letras"
			},
			"produto.descricao" : {
				required : "Descri��o � obrigat�rio",
				maxlength : "Descri��o precisa ter menos de 40 letras"
			},
			"produto.preco" : {
				required : "Pre�o � obrigat�rio",
				min : "Pre�o precisa ser positivo"
			},
		},
	});
});