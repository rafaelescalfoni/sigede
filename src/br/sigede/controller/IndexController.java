package br.sigede.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Area;
import br.sigede.model.Status;
import br.sigede.model.Usuario;
import br.sigede.utils.anotacoes.Public;
import br.sigede.utils.componentes.PerfilEnum;
import br.sigede.utils.componentes.UserSession;

@Resource
public class IndexController {
	private final Result result;
	private final DAOFactory daoFactory;
	private final UserSession userSession;

	public IndexController(Result result, DAOFactory daoFactory,
			UserSession userSession) {
		this.result = result;
		this.daoFactory = daoFactory;
		this.userSession = userSession;
	}

	// requisicoes recebidas pelo controller
	@Public
	@Get("/")
	public void login() {
		this.initBanco();
	}

	@Public
	public void login(String msg) {
		result.include("mensagemErro", msg);
	}

	@Get
	@Path("/home")
	public void home() {
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
	}

	// processamento de requisicoes
	@Post
	@Path("/autenticar")
	public void autenticar(Usuario usuario) {
		String strQuery = "SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", usuario.getEmail());
		params.put("senha", usuario.getSenha());

		usuario = daoFactory.getUsuarioDAO().get(strQuery, params);
		
		if (usuario != null) {
			userSession.setUsuario(usuario);
			result.redirectTo(this).home();
		} else {
			result.redirectTo(this).login("Usu�rio inv�lido");
		}
	}

	private void initBanco() {
		// verificar se o BD est� vazio
		List<Usuario> usuarioList = daoFactory.getUsuarioDAO().list();
		// se estiver, criar um usu�rio padr�o
		if (usuarioList == null || usuarioList.size() == 0) {
			Area areaPadrao = new Area();
			areaPadrao.setNome("Coordena��o de Gest�o de Tecnologia da Informa��o - CGTI");
			daoFactory.getAreaDAO().add(areaPadrao);
			
			Status statusPadrao = new Status();
			statusPadrao.setNome("Ativo");
			daoFactory.getStatusDAO().add(statusPadrao);
			
			Usuario usuarioPadrao = new Usuario();
			usuarioPadrao.setData_cadastro(new Date()); // retorna a data e a hora atual
			usuarioPadrao.setNome("Usu�rio Padr�o");
			usuarioPadrao.setEmail("admin@admin.com.br");
			usuarioPadrao.setSenha("admin");
			usuarioPadrao.setTelefone("(21)2222-2222");
			usuarioPadrao.setArea(areaPadrao);
			usuarioPadrao.setPerfil(PerfilEnum.ADMINISTRADOR.getNome());
			usuarioPadrao.setStatus(statusPadrao);
			daoFactory.getUsuarioDAO().add(usuarioPadrao);
		}
	}
	
	

	
	
}
