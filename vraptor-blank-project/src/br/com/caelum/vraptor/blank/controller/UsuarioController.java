package br.com.caelum.vraptor.blank.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.blank.dao.UsuarioDao;
import br.com.caelum.vraptor.blank.model.Usuario;
import br.com.caelum.vraptor.blank.model.UsuarioWeb;
import br.com.caelum.vraptor.validator.ValidationMessage;

@Resource
public class UsuarioController {

	private final UsuarioDao dao;
	private final Result result;
	private final Validator validator;
	private final UsuarioWeb usuarioWeb;

	public UsuarioController(UsuarioDao dao, Result result,
			Validator validator, UsuarioWeb usuarioWeb) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	@Get("/usuario/novo")
	public void novo() {  
		System.out.println("Novo...");
	}

	@Post("/usuario")
	public void adiciona(Usuario usuario) {
		if (dao.existeUsuario(usuario)) {
			validator.add(new ValidationMessage("Login já existe!",
					"usuario.login"));
		}
		validator.onErrorUsePageOf(this).novo();
		dao.adiciona(usuario);
		result.redirectTo(ProdutoController.class).lista();
	}

	@Get("/login")
	public void loginForm() {  }

	@Post("/login")
	public void login(Usuario usuario) {
		Usuario carregado = dao.carrega(usuario);
		if(carregado == null) {
			validator.add(new ValidationMessage("Login e/ou senha inválidos", "usuario.login"));
		}
		
		validator.onErrorUsePageOf(this).loginForm();
		usuarioWeb.login(carregado);
		result.redirectTo(ProdutoController.class).lista();
	}
	
	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo(ProdutoController.class).lista();
	}
	
}
