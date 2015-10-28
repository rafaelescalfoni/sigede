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
		// verificar se o bd está vazio
		List<Usuario> usuarioList = daoFactory.getUsuarioDAO().list();
		// se estiver, criar um usuario padrão
		if (usuarioList == null || usuarioList.size() == 0) {
			Usuario usuarioPadrao = new Usuario();
			usuarioPadrao.setNome("Padrão");
			usuarioPadrao.setData_cadastro(new Date()); // retorna hora do
			usuarioPadrao.setArea("Padrão");
			usuarioPadrao.setPerfil(PerfilEnum.ADMINISTRADOR.getNome());
			usuarioPadrao.setSenha("admin");
			usuarioPadrao.setEmail("admin@admin.com");
			usuarioPadrao.setTelefone("(21)2222-2222");
			daoFactory.getUsuarioDAO().add(usuarioPadrao);
		}
	}
}
