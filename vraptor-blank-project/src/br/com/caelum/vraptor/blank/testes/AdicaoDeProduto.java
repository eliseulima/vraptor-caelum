package br.com.caelum.vraptor.blank.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.blank.dao.ProdutoDao;
import br.com.caelum.vraptor.blank.infra.CriadorDeSession;
import br.com.caelum.vraptor.blank.infra.CriadorDeSessionFactory;
import br.com.caelum.vraptor.blank.model.Produto;

public class AdicaoDeProduto {
	
	public static void main(String[] args) {
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		Session session = new CriadorDeSession(factory).getInstance();
		ProdutoDao dao = new ProdutoDao(session);
		
		Produto produto = criaProduto();
		dao.salva(produto);
	}

	private static Produto criaProduto() {
		Produto produto = new Produto();
		produto.setNome("teste nome");
		produto.setDescricao("teste descricao");
		produto.setPreco(26.99);
		return produto;
	}

}
