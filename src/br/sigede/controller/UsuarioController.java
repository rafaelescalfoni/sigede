package br.sigede.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
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
		
	@Get @Path("/suporte/usuario/{inicio}/{fim}")
	public void list(int inicio, int fim) {
		String strQuery = "FROM Usuario u";
		Map<String, Object> params = new HashMap<String, Object>();
		List<Usuario> lista = daoFactory.getUsuarioDAO().list(strQuery, params, inicio, fim);
		result.use(Results.xml()).from(lista, "usuario").serialize();
	}
	
	@Get("/suporte/usuario/{usuarioId}")
	public void cadastrar_usuario(Long usuarioId) {
		System.out.println("\n\n8º \n\n");
		Usuario usuario = daoFactory.getUsuarioDAO().get(usuarioId); //pesquisar o usuario no bd
		result.include("usuario", usuario); //botar o usuario a disposicao da jsp
	}	
	
	@Path("/logout")
	 public void logout() {
	    userSession.logout();
	    result.redirectTo(IndexController.class).login();
	}
	
	
}
