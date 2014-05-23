$(function() {
	$("#usuariosForm").validate({
		rules : {
			"usuario.nome" : { required : true }, 
			"usuario.login" : { required : true },
			"usuario.senha" : { required : true },
		},
		messages : {
			"usuario.nome" : { required : "Nome é obrigatório" },
			"usuario.login" : { required : "Login é obrigatório" },
			"usuario.senha" : { required : "Senha é obrigatório" },
		},
	});
});