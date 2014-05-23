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
				required : "Nome é obrigatório",
				minLength : "Nome precisa ter mais de 3 letras"
			},
			"produto.descricao" : {
				required : "Descrição é obrigatório",
				maxlength : "Descrição precisa ter menos de 40 letras"
			},
			"produto.preco" : {
				required : "Preço é obrigatório",
				min : "Preço precisa ser positivo"
			},
		},
	});
});