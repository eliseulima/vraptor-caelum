package br.com.caelum.vraptor.blank.testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.blank.dao.ProdutoDao;
import br.com.caelum.vraptor.blank.infra.CriadorDeSession;
import br.com.caelum.vraptor.blank.infra.CriadorDeSessionFactory;
import br.com.caelum.vraptor.blank.model.Produto;

public class AlteracaoDeProduto {
	
	public static void main(String[] args) {
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		Session session = new CriadorDeSession(factory).getInstance();
		ProdutoDao dao = new ProdutoDao(session);
		
		Produto produto = setandoProduto(session);
		produto.setNome("testes nomes");
		produto.setDescricao("testes descricoes");
		produto.setPreco(20.09);
		dao.atualiza(produto);
	}
	
	private static Produto setandoProduto(Session session) {
		Produto produto = (Produto) session.load(Produto.class, 13L);
		return produto;
	}

}
