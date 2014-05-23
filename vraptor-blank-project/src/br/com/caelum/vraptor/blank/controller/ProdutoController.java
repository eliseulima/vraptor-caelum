package br.com.caelum.vraptor.blank.controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.blank.dao.ProdutoDao;
import br.com.caelum.vraptor.blank.infra.AutorizacaoInterceptor.Restrito;
import br.com.caelum.vraptor.blank.model.Produto;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.validator.Validations;
import static br.com.caelum.vraptor.view.Results.*;

@Resource
public class ProdutoController {
	
	private final ProdutoDao dao;
	private final Result result;
	private final Validator validator;
	
	public ProdutoController(ProdutoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}
	
	@Restrito
	@Get("/produtos/novo")
	public void formulario() {  }

	@Restrito
	@Post("/produtos")
	public void adiciona(Produto produto) {
		//validator.validate(produto);
		//validacaoClassia(produto);
		validacaoInternacional(produto);
		validator.onErrorUsePageOf(this).formulario();
		dao.salva(produto);
		result.redirectTo(this).lista();
	}

	@Restrito
	@Get("/produtos/{id}")
	public Produto edita(Long id) {
		return dao.carrega(id);
	}
	
	@Restrito
	@Put("/produtos/{produto.id}")
	public void altera(Produto produto) {
		//validator.validate(produto);
		//validacaoClassia(produto);
		validacaoInternacional(produto);
		validator.onErrorUsePageOf(this).formulario();
		dao.atualiza(produto);
		result.redirectTo(this).lista();
	}
	
	@Restrito
	@Delete("/produtos/{id}")
	public void remove(Long id) {
		Produto produto = dao.carrega(id);
		dao.remove(produto);
		result.redirectTo(this).lista();
	}
	
	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}
	
	@Get("/produtos/busca.json")
	public void buscaJson(String q) {
		List<Produto> busca = dao.busca(q);
		result.use(json()).withoutRoot().from(busca).exclude("id", "descricao").serialize();
	}
	
	@Get("/produtos")
	public List<Produto> lista() {
		return dao.listaTudo();
	}
	
	private void validacaoClassia(Produto produto) {
		if(produto.getNome() == null || produto.getNome().length() < 3) {
			validator.add(new ValidationMessage("Nome é obrigatório e precisa ter mais de 3 letras ", "produto.nome"));
		}
		if(produto.getDescricao() == null || produto.getDescricao().length() > 40) {
			validator.add(new ValidationMessage("Descrição é obrigatório e precisa ter menos de 40 letras", "produto.descricao"));
		}
		if(produto.getPreco() <= 0.0) {
			validator.add(new ValidationMessage("Preço precisa ser positivo", "produto.preco"));
		}
	}
	
	private void validacaoInternacional(final Produto produto) {
		validator.checking(new Validations(){{
			that(produto.getNome() != null && produto.getNome().length() >= 3,"produto.nome","nome.obrigatorio");
			that(produto.getDescricao() != null && produto.getDescricao().length() <= 40,"produto.descricao","descricao.obrigatorio");
			that(produto.getPreco() != null && produto.getPreco() > 0.0, "produto.preco", "preco.positivo");
		}});
	}
	
}
