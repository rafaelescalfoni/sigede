package br.sigede.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import br.sigede.utils.componentes.UserSession;

@Resource
public class AdminController {
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
	
	public AdminController(Result result, UserSession userSession, DAOFactory daoFactory) {
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}

	
	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página do usuário
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/usuario")
	public void usuarioCrud(){
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
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("areaList", AreaEnum.getList());
		result.include("perfilList", PerfilEnum.getList());
		result.include("statusList", StatusEnum.getList());
	}
	
	@Get @Path("/admin/suporte/usuario/{usuarioId}/update")
	public void edicao_usuario(Long usuarioId){
		result.include("usuario", daoFactory.getUsuarioDAO().get(usuarioId));
		result.include("areaList", AreaEnum.getList());
		result.include("perfilList", PerfilEnum.getList());
		result.include("statusList", StatusEnum.getList());
	}
	
	@Get @Path("/admin/suporte/usuario/{usuarioId}")
	public void usuarioCrud(Long usuarioId){
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
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date data_atual = new Date();
		usuario.setData_cadastro(formatador.format(data_atual));
		daoFactory.getUsuarioDAO().add(usuario);
		result.redirectTo(this).usuarioCrud();
	}
	
	@Put @Path("/suporte/usuario/{usuario.id}") 
	public void update(Usuario usuario) {
		daoFactory.getUsuarioDAO().update(usuario);
		result.redirectTo(this).usuarioCrud();
	}
	
	@Delete @Path("/suporte/usuario/{usuario.id}") //
	public void delete(Usuario usuario) {
		daoFactory.getUsuarioDAO().delete(usuario);
		result.redirectTo(this).usuarioCrud();
	}
	
	
}
