package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Usuario;
import br.sigede.utils.componentes.UserSession;

@Resource
public class UsuarioController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
		
	public UsuarioController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
		
	@Get("/suporte/usuario/{usuarioId}")
	public void cadastrar_usuario(Long usuarioId) {
		Usuario usuario = daoFactory.getUsuarioDAO().get(usuarioId); //pesquisar o usuario no bd
		result.include("usuario", usuario); //botar o usuario a disposicao da jsp
	}	
	
	@Path("/logout")
	 public void logout() {
	    userSession.logout();
	    result.redirectTo(IndexController.class).login();
	}
}
