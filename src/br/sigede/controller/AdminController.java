package br.sigede.controller;

import java.util.Date;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Area;
import br.sigede.model.Status;
import br.sigede.model.TipoDemanda;
import br.sigede.model.TipoRelatorioAudin;
import br.sigede.model.TipoRelatorioDo;
import br.sigede.model.Usuario;
import br.sigede.utils.componentes.PerfilEnum;
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
		result.include("areaList", daoFactory.getAreaDAO().list());
		result.include("perfilList", PerfilEnum.getList());
		result.include("statusList", daoFactory.getStatusDAO().list());
	}
	
	public void usuarioCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	@Get("/admin/usuario/cadastrar_usuario")
	public void cadastrar_usuario(){	
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("areaList", daoFactory.getAreaDAO().list());
		result.include("perfilList", PerfilEnum.getList());
		result.include("statusList", daoFactory.getStatusDAO().list());
	}
	
	@Get @Path("/admin/suporte/usuario/{usuarioId}/update")
	public void edicao_usuario(Long usuarioId){
		result.include("usuario", daoFactory.getUsuarioDAO().get(usuarioId));
		result.include("areaList", daoFactory.getAreaDAO().list());
		result.include("perfilList", PerfilEnum.getList());
		result.include("statusList", daoFactory.getStatusDAO().list());
	}
	
	//@Delete @Path("/admin/suporte/usuario/{usuarioId}")
	//public void usuarioCrud(Long usuarioId){
	//	result.include("usuarioList", daoFactory.getUsuarioDAO().list());
	//	result.include("areaList", daoFactory.getAreaDAO().list());
	//	result.include("statusList", daoFactory.getStatusDAO().list());
	//}

	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página da área
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/area")
	public void areaCrud(){
		result.include("areaList", daoFactory.getAreaDAO().list());
	}
	
	public void areaCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	@Get("/admin/area/cadastrar_area")
	public void cadastrar_area(){	
	}
	
	@Get @Path("/admin/suporte/area/{areaId}/update")
	public void edicao_area(Long areaId){
		result.include("area", daoFactory.getAreaDAO().get(areaId));
	}
	
	@Delete @Path("/admin/suporte/area/{areaId}")
	public void areaCrud(Long areaId){
		result.include("areaList", daoFactory.getAreaDAO().list());
	}
	
	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página do status do usuário
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/status")
	public void statusCrud(){
		result.include("statusList", daoFactory.getStatusDAO().list());
	}
		
	public void statusCrud(String msg) {
		result.include("mensagemErro", msg);
	}
		
	@Get("/admin/status/cadastrar_status")
	public void cadastrar_status(){	
	}
		
	@Get @Path("/admin/suporte/status/{statusId}/update")
	public void edicao_status(Long statusId){
		result.include("status", daoFactory.getStatusDAO().get(statusId));
	}
		
	@Delete @Path("/admin/suporte/status/{statusId}")
	public void statusCrud(Long statusId){
		result.include("statusList", daoFactory.getStatusDAO().list());	
	}
	
	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página do tipo de demanda
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/tipodemanda")
	public void tipodemandaCrud(){
		result.include("tipodemandaList", daoFactory.getTipoDemandaDAO().list());
	}
	
	public void tipodemandaCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	@Get("/admin/tipodemanda/cadastrar_tipodemanda")
	public void cadastrar_tipodemanda(){	
	}
	
	@Get @Path("/admin/suporte/tipodemanda/{tipodemandaId}/update")
	public void edicao_tipodemanda(Long tipodemandaId){
		result.include("tipodemanda", daoFactory.getTipoDemandaDAO().get(tipodemandaId));
	}
	
	@Delete @Path("/admin/suporte/tipodemanda/{tipodemandaId}")
	public void tipodemandaCrud(Long tipodemandaId){
		result.include("tipodemandaList", daoFactory.getTipoDemandaDAO().list());
	}

	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página do tipo de relatório audin
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/tiporelatorioaudin")
	public void tiporelatorioaudinCrud(){
		result.include("tiporelatorioaudinList", daoFactory.getTipoRelatorioAudinDAO().list());
	}
	
	public void tiporelatorioaudinCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	@Get("/admin/tiporelatorioaudin/cadastrar_tiporelatorioaudin")
	public void cadastrar_tiporelatorioaudin(){	
	}
	
	@Get @Path("/admin/suporte/tiporelatorioaudin/{tiporelatorioaudinId}/update")
	public void edicao_tiporelatorioaudin(Long tiporelatorioaudinId){
		result.include("tiporelatorioaudin", daoFactory.getTipoRelatorioAudinDAO().get(tiporelatorioaudinId));
	}
	
	@Delete @Path("/admin/suporte/tiporelatorioaudin/{tiporelatorioaudinId}")
	public void tiporelatorioaudinCrud(Long tiporelatorioaudinId){
		result.include("tiporelatorioaudinList", daoFactory.getTipoRelatorioAudinDAO().list());
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////
	//metodos de chamadas de página do tipo de relatório dos demais órgãos de controle
	////////////////////////////////////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/tiporelatoriodo")
	public void tiporelatoriodoCrud(){
		result.include("tiporelatoriodoList", daoFactory.getTipoRelatorioDoDAO().list());
	}
	
	public void tiporelatoriodoCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	@Get("/admin/tiporelatoriodo/cadastrar_tiporelatoriodo")
	public void cadastrar_tiporelatoriodo(){	
	}
	
	@Get @Path("/admin/suporte/tiporelatoriodo/{tiporelatoriodoId}/update")
	public void edicao_tiporelatoriodo(Long tiporelatoriodoId){
		result.include("tiporelatoriodo", daoFactory.getTipoRelatorioDoDAO().get(tiporelatoriodoId));
	}
	
	@Delete @Path("/admin/suporte/tiporelatoriodo/{tiporelatoriodoId}")
	public void tiporelatoriodoCrud(Long tiporelatoriodoId){
		result.include("tiporelatoriodoList", daoFactory.getTipoRelatorioDoDAO().list());
	}
	
	
	/////////////////////////////////////
	// metodos CRUD
	/////////////////////////////////////
	@Post @Path("/suporte/usuario")
	public void add(Usuario usuario) {
		daoFactory.getUsuarioDAO().add(usuario);
		usuario.setData_cadastro(new Date()); // cadastra a data e a hora atual
		result.redirectTo(this).usuarioCrud();
	}
	
	@Put @Path("/suporte/usuario/{usuario.id}") 
	public void update(Usuario usuario) {
		daoFactory.getUsuarioDAO().update(usuario);
		result.redirectTo(this).usuarioCrud();
	}
	
	@Delete @Path("/suporte/usuario/{usuario.id}") //
	public void usuarioCrud(Usuario usuario) {
		daoFactory.getUsuarioDAO().update(usuario);
		result.redirectTo(this).usuarioCrud();
	}
	
	@Post @Path("/suporte/area")
	public void add(Area area) {
		daoFactory.getAreaDAO().add(area);
		result.redirectTo(this).areaCrud();
	}
	
	@Put @Path("/suporte/area/{area.id}")
	public void update(Area area) {
		daoFactory.getAreaDAO().update(area);
		result.redirectTo(this).areaCrud();
	}
	
	@Post @Path("/suporte/status")
	public void add(Status status) {
		daoFactory.getStatusDAO().add(status);
		result.redirectTo(this).statusCrud();
	}
	
	@Put @Path("/suporte/status/{status.id}")
	public void update(Status status) {
		daoFactory.getStatusDAO().update(status);
		result.redirectTo(this).statusCrud();
	}
	
	@Post @Path("/suporte/tipodemanda")
	public void add(TipoDemanda tipoDemanda) {
		daoFactory.getTipoDemandaDAO().add(tipoDemanda);
		result.redirectTo(this).tipodemandaCrud();
	}
	
	@Put @Path("/suporte/tipodemanda/{tipodemanda.id}")
	public void update(TipoDemanda tipoDemanda) {
		daoFactory.getTipoDemandaDAO().update(tipoDemanda);
		result.redirectTo(this).tipodemandaCrud();
	}
	
	@Post @Path("/suporte/tiporelatorioaudin")
	public void add(TipoRelatorioAudin tipoRelatorioAudin) {
		daoFactory.getTipoRelatorioAudinDAO().add(tipoRelatorioAudin);
		result.redirectTo(this).tiporelatorioaudinCrud();
	}
	
	@Put @Path("/suporte/tiporelatorioaudin/{tiporelatorioaudin.id}")
	public void update(TipoRelatorioAudin tipoRelatorioAudin) {
		daoFactory.getTipoRelatorioAudinDAO().update(tipoRelatorioAudin);
		result.redirectTo(this).tiporelatorioaudinCrud();
	}
	
	@Post @Path("/suporte/tiporelatoriodo")
	public void add(TipoRelatorioDo tipoRelatorioDo) {
		daoFactory.getTipoRelatorioDoDAO().add(tipoRelatorioDo);
		result.redirectTo(this).tiporelatoriodoCrud();
	}
	
	@Put @Path("/suporte/tiporelatoriodo/{tiporelatoriodo.id}")
	public void update(TipoRelatorioDo tipoRelatorioDo) {
		daoFactory.getTipoRelatorioDoDAO().update(tipoRelatorioDo);
		result.redirectTo(this).tiporelatoriodoCrud();
	}
	
	
}
