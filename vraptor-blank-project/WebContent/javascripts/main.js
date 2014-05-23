$(function(){
	$("#busca").puts("Busca produtos por nome");
	$("#busca").autocomplete('produtos/busca.json', {
		dataType : "json",
		parse : function(produtos) {
			return $.map(produtos, function(produto) {
				return {
					data : produto,
					value : produto.nome,
					result : produto.nome
				};
			});
		},
		formatItem : function(produto) {
			return produto.nome + "(" + produto.preco + ")";
		}
	});
});