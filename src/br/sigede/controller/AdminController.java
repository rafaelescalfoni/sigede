package br.sigede.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Usuario;
import br.sigede.utils.componentes.AreaEnum;
import br.sigede.utils.componentes.PerfilEnum;
import br.sigede.utils.componentes.StatusEnum;

@Resource
public class AdminController {
	private final Result result;
	private final DAOFactory daoFactory;
	
	public AdminController(Result result, DAOFactory daoFactory) {
		this.result = result;
		this.daoFactory = daoFactory;
	}

	
	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página do usuário
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/usuario")
	public void usuarioCrud(){
		System.out.println("\n\n1º - listaCadastro\n\n");
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("areaList", AreaEnum.getList());
		result.include("perfilList", PerfilEnum.getList());
		result.include("statusList", StatusEnum.getList());
	}
	
	public void usuarioCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	@Get("/admin/usuario/cadastrar_usuario")
	public void cadastrar_usuario(){	
		System.out.println("\n\n2º Abre a tela de cadastro de Usuários\n\n");
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("areaList", AreaEnum.getList());
		result.include("perfilList", PerfilEnum.getList());
		result.include("statusList", StatusEnum.getList());
	}
	
	@Get @Path("/admin/suporte/usuario/{usuarioId}/update")
	public void edicao_usuario(Long usuarioId){
		System.out.println("\n\n4º Abre formulário de edição do Usuário\n\n");
		result.include("usuario", daoFactory.getUsuarioDAO().get(usuarioId));
		result.include("areaList", AreaEnum.getList());
		result.include("perfilList", PerfilEnum.getList());
		result.include("statusList", StatusEnum.getList());
	}
	


	
	
	/////////////////////////////////////
	// metodos CRUD
	/////////////////////////////////////
	@Post @Path("/suporte/usuario")
	public void add(Usuario usuario) {
		System.out.println("\n\n3º Salva o Usuário no BD\n\n");
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date data_atual = new Date();
		usuario.setData_cadastro(formatador.format(data_atual));
		daoFactory.getUsuarioDAO().add(usuario);
		result.redirectTo(this).usuarioCrud();
	}
	
	@Put @Path("/suporte/usuario/{usuario.id}") 
	public void update(Usuario usuario) {
		System.out.println("\n\n5º Salva a alteração do Usuário\n\n");
		daoFactory.getUsuarioDAO().update(usuario);
		result.redirectTo(this).usuarioCrud();
	}
	
	@Delete @Path("/suporte/usuario/{usuario.id}") 
	public void delete(Usuario usuario) {
		System.out.println("\n\n6º Deleta o Usuário\n\n");
		daoFactory.getUsuarioDAO().delete(usuario);
		result.redirectTo(this).usuarioCrud();
	}
	
	@Get @Path("/admin/suporte/pesquisa")
  	public void consulta_usuario(String palavraChave){ 
		System.out.println("\n\n7º Faz a pesquisa pelo usuário\n\n");
  		String strQuery = "FROM Usuario u "
  						  + "WHERE u.nome LIKE :trechoChave OR "
  						  + " 	   u.data_cadastro LIKE :trechoChave OR "
  						  + " 	   u.email LIKE :trechoChave OR "
  						  + " 	   u.telefone LIKE :trechoChave OR "
  						  + " 	   u.area LIKE :trechoChave OR "
  						  + "	   u.perfil LIKE :trechoChave OR "
  						  + "      u.status LIKE :trechoChave";
  		
  		Map<String, Object> params = new HashMap<String, Object>();
  		params.put("trechoChave", "%" + palavraChave + "%");
  		List<Usuario>usuariosEncontrados = daoFactory.getUsuarioDAO().list(strQuery, params);
  		result.include("usuariosEncontrados", usuariosEncontrados);
  	}
	
	
}
