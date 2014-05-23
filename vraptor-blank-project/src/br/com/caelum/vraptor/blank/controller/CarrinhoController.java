package br.com.caelum.vraptor.blank.controller;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.blank.dao.ProdutoDao;
import br.com.caelum.vraptor.blank.model.Carrinho;
import br.com.caelum.vraptor.blank.model.Item;

@Resource
public class CarrinhoController {
	
	private final Carrinho carrinho;
	private final ProdutoDao dao;
	private final Result result;
	
	public CarrinhoController(Carrinho carrinho, ProdutoDao dao, Result result) {
		this.carrinho = carrinho;
		this.dao = dao;
		this.result = result;
	}
	
	@Get("/carrinho")
	public void visualiza() {  }
	
	@Post("/carrinho")
	public void adiciona(Item item) {
		dao.recarrega(item.getProduto());
		carrinho.adiciona(item);
		result.redirectTo(this).visualiza();
	}
	
	@Delete("/carrinho/{indiceItem}")
	public void remove(int indiceItem) {
		carrinho.remove(indiceItem);
		result.redirectTo(this).visualiza();
	}
	
}
