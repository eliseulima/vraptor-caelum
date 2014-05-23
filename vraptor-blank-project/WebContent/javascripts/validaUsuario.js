$(function() {
	$("#usuariosForm").validate({
		rules : {
			"usuario.nome" : { required : true }, 
			"usuario.login" : { required : true },
			"usuario.senha" : { required : true },
		},
		messages : {
			"usuario.nome" : { required : "Nome � obrigat�rio" },
			"usuario.login" : { required : "Login � obrigat�rio" },
			"usuario.senha" : { required : "Senha � obrigat�rio" },
		},
	});
});