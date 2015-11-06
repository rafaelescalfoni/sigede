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
import br.sigede.model.Ano;
import br.sigede.model.Area;
import br.sigede.model.AreaTematica;
import br.sigede.model.Colegiado;
import br.sigede.model.Foco;
import br.sigede.model.Natureza;
import br.sigede.model.Status;
import br.sigede.model.StatusRegistro;
import br.sigede.model.TipoDemanda;
import br.sigede.model.TipoRelatorioAudin;
import br.sigede.model.TipoRelatorioDo;
import br.sigede.model.Unidade;
import br.sigede.model.UnidadeAuditada;
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
	
	@Get @Path("/admin/suporte/usuario/{usuarioId}")
	public void usuarioCrud(Long usuarioId){
		result.include("usuario", daoFactory.getUsuarioDAO().get(usuarioId));
	}

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
	
	@Get @Path("/admin/suporte/area/{areaId}")
	public void areaCrud(Long areaId){
		result.include("area", daoFactory.getAreaDAO().get(areaId));
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
		
	@Get @Path("/admin/suporte/status/{statusId}")
	public void statusCrud(Long statusId){
		result.include("status", daoFactory.getStatusDAO().get(statusId));
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
	
	@Get @Path("/admin/suporte/tipodemanda/{tipodemandaId}")
	public void tipodemandaCrud(Long tipodemandaId){
		result.include("tipodemanda", daoFactory.getTipoDemandaDAO().get(tipodemandaId));
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
	
	@Get @Path("/admin/suporte/tiporelatorioaudin/{tiporelatorioaudinId}")
	public void tiporelatorioaudinCrud(Long tiporelatorioaudinId){
		result.include("tiporelatorioaudin", daoFactory.getTipoRelatorioAudinDAO().get(tiporelatorioaudinId));
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
	
	@Get @Path("/admin/suporte/tiporelatoriodo/{tiporelatoriodoId}")
	public void tiporelatoriodoCrud(Long tiporelatoriodoId){
		result.include("tiporelatoriodo", daoFactory.getTipoRelatorioDoDAO().get(tiporelatoriodoId));
	}
	
	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página do ano
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/ano")
	public void anoCrud(){
		result.include("anoList", daoFactory.getAnoDAO().list());
	}
	
	public void anoCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	@Get("/admin/ano/cadastrar_ano")
	public void cadastrar_ano(){	
	}
	
	@Get @Path("/admin/suporte/ano/{anoId}/update")
	public void edicao_ano(Long anoId){
		result.include("ano", daoFactory.getAnoDAO().get(anoId));
	}
	
	@Get @Path("/admin/suporte/ano/{anoId}")
	public void anoCrud(Long anoId){
		result.include("ano", daoFactory.getAnoDAO().get(anoId));
	}
	
	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página do foco
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/foco")
	public void focoCrud(){
		result.include("focoList", daoFactory.getFocoDAO().list());
	}
				
	public void focoCrud(String msg) {
		result.include("mensagemErro", msg);
	}
				
	@Get("/admin/foco/cadastrar_foco")
	public void cadastrar_foco(){	
	}
				
	@Get @Path("/admin/suporte/foco/{focoId}/update")
	public void edicao_foco(Long focoId){
		result.include("foco", daoFactory.getFocoDAO().get(focoId));
	}
				
	@Get @Path("/admin/suporte/foco/{focoId}/delete")
	public void focoCrud(Long focoId){
		result.include("foco", daoFactory.getFocoDAO().get(focoId));
	}
	
	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página da unidade auditada
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/unidadeauditada")
	public void unidadeauditadaCrud(){
		result.include("unidadeauditadaList", daoFactory.getUnidadeAuditadaDAO().list());
	}
				
	public void unidadeauditadaCrud(String msg) {
		result.include("mensagemErro", msg);
	}
				
	@Get("/admin/unidadeauditada/cadastrar_unidadeauditada")
	public void cadastrar_unidadeauditada(){	
	}
				
	@Get @Path("/admin/suporte/unidadeauditada/{unidadeauditadaId}/update")
	public void edicao_unidadeauditada(Long unidadeauditadaId){
		result.include("unidadeauditada", daoFactory.getUnidadeAuditadaDAO().get(unidadeauditadaId));
	}
				
	@Get @Path("/admin/suporte/unidadeauditada/{unidadeauditadaId}/delete")
	public void unidadeauditadaCrud(Long unidadeauditadaId){
		result.include("unidadeauditada", daoFactory.getUnidadeAuditadaDAO().get(unidadeauditadaId));
	}
	
	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página da natureza
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/natureza")
	public void naturezaCrud(){
		result.include("naturezaList", daoFactory.getNaturezaDAO().list());
	}
				
	public void naturezaCrud(String msg) {
		result.include("mensagemErro", msg);
	}
				
	@Get("/admin/natureza/cadastrar_natureza")
	public void cadastrar_natureza(){	
	}
				
	@Get @Path("/admin/suporte/natureza/{naturezaId}/update")
	public void edicao_natureza(Long naturezaId){
		result.include("natureza", daoFactory.getNaturezaDAO().get(naturezaId));
	}
				
	@Get @Path("/admin/suporte/natureza/{naturezaId}/delete")
	public void naturezaCrud(Long naturezaId){
		result.include("natureza", daoFactory.getNaturezaDAO().get(naturezaId));
	}

	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página do colegiado
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/colegiado")
	public void colegiadoCrud(){
		result.include("colegiadoList", daoFactory.getColegiadoDAO().list());
	}
				
	public void colegiadoCrud(String msg) {
		result.include("mensagemErro", msg);
	}
				
	@Get("/admin/colegiado/cadastrar_colegiado")
	public void cadastrar_colegiado(){	
	}
				
	@Get @Path("/admin/suporte/colegiado/{colegiadoId}/update")
	public void edicao_colegiado(Long colegiadoId){
		result.include("colegiado", daoFactory.getColegiadoDAO().get(colegiadoId));
	}
				
	@Get @Path("/admin/suporte/colegiado/{colegiadoId}/delete")
	public void colegiadoCrud(Long colegiadoId){
		result.include("colegiado", daoFactory.getColegiadoDAO().get(colegiadoId));
	}

	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página da área temática
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/areatematica")
	public void areatematicaCrud(){
		result.include("areatematicaList", daoFactory.getAreaTematicaDAO().list());
	}
				
	public void areatematicaCrud(String msg) {
		result.include("mensagemErro", msg);
	}
				
	@Get("/admin/areatematica/cadastrar_areatematica")
	public void cadastrar_areatematica(){	
	}
				
	@Get @Path("/admin/suporte/areatematica/{areatematicaId}/update")
	public void edicao_areatematica(Long areatematicaId){
		result.include("areatematica", daoFactory.getAreaTematicaDAO().get(areatematicaId));
	}
				
	@Get @Path("/admin/suporte/areatematica/{areatematicaId}/delete")
	public void areatematicaCrud(Long areatematicaId){
		result.include("areatematica", daoFactory.getAreaTematicaDAO().get(areatematicaId));
	}

	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página da unidade
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/unidade")
	public void unidadeCrud(){
		result.include("unidadeList", daoFactory.getUnidadeDAO().list());
	}
				
	public void unidadeCrud(String msg) {
		result.include("mensagemErro", msg);
	}
				
	@Get("/admin/unidade/cadastrar_unidade")
	public void cadastrar_unidade(){	
	}
				
	@Get @Path("/admin/suporte/unidade/{unidadeId}/update")
	public void edicao_unidade(Long unidadeId){
		result.include("unidade", daoFactory.getUnidadeDAO().get(unidadeId));
	}
				
	@Get @Path("/admin/suporte/unidade/{unidadeId}/delete")
	public void unidadeCrud(Long unidadeId){
		result.include("unidade", daoFactory.getUnidadeDAO().get(unidadeId));
	}

	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página do status do registro
	//////////////////////////////////////////////////////////////////
	@Get @Path("/admin/suporte/statusregistro")
	public void statusregistroCrud(){
		result.include("statusregistroList", daoFactory.getStatusRegistroDAO().list());
	}
				
	public void statusregistroCrud(String msg) {
		result.include("mensagemErro", msg);
	}
				
	@Get("/admin/statusregistro/cadastrar_statusregistro")
	public void cadastrar_statusregistro(){	
	}
				
	@Get @Path("/admin/suporte/statusregistro/{statusregistroId}/update")
	public void edicao_statusregistro(Long statusregistroId){
		result.include("statusregistro", daoFactory.getStatusRegistroDAO().get(statusregistroId));
	}
				
	@Get @Path("/admin/suporte/statusregistro/{statusregistroId}/delete")
	public void statusregistroCrud(Long statusregistroId){
		result.include("statusregistro", daoFactory.getStatusRegistroDAO().get(statusregistroId));
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
	public void delete(Usuario usuario) {
		daoFactory.getUsuarioDAO().delete(usuario);
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
	
	@Delete @Path("/suporte/area/{area.id}")
	public void delete(Area area) {
		daoFactory.getAreaDAO().delete(area);
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
	
	@Delete @Path("/suporte/status/{status.id}")
	public void delete(Status status) {
		daoFactory.getStatusDAO().delete(status);
		result.redirectTo(this).statusCrud();
	}
	
	@Post @Path("/suporte/tipodemanda")
	public void add(TipoDemanda tipodemanda) {
		daoFactory.getTipoDemandaDAO().add(tipodemanda);
		result.redirectTo(this).tipodemandaCrud();
	}
	
	@Put @Path("/suporte/tipodemanda/{tipodemanda.id}")
	public void update(TipoDemanda tipodemanda) {
		daoFactory.getTipoDemandaDAO().update(tipodemanda);
		result.redirectTo(this).tipodemandaCrud();
	}
	
	@Delete @Path("/suporte/tipodemanda/{tipodemanda.id}")
	public void delete(TipoDemanda tipodemanda) {
		daoFactory.getTipoDemandaDAO().delete(tipodemanda);
		result.redirectTo(this).tipodemandaCrud();
	}
	
	@Post @Path("/suporte/tiporelatorioaudin")
	public void add(TipoRelatorioAudin tiporelatorioaudin) {
		daoFactory.getTipoRelatorioAudinDAO().add(tiporelatorioaudin);
		result.redirectTo(this).tiporelatorioaudinCrud();
	}
	
	@Put @Path("/suporte/tiporelatorioaudin/{tiporelatorioaudin.id}")
	public void update(TipoRelatorioAudin tiporelatorioaudin) {
		daoFactory.getTipoRelatorioAudinDAO().update(tiporelatorioaudin);
		result.redirectTo(this).tiporelatorioaudinCrud();
	}
	
	@Delete @Path("/suporte/tiporelatorioaudin/{tiporelatorioaudin.id}")
	public void delete(TipoRelatorioAudin tiporelatorioaudin) {
		daoFactory.getTipoRelatorioAudinDAO().delete(tiporelatorioaudin);
		result.redirectTo(this).tiporelatorioaudinCrud();
	}
	
	@Post @Path("/suporte/tiporelatoriodo")
	public void add(TipoRelatorioDo tiporelatoriodo) {
		daoFactory.getTipoRelatorioDoDAO().add(tiporelatoriodo);
		result.redirectTo(this).tiporelatoriodoCrud();
	}
	
	@Put @Path("/suporte/tiporelatoriodo/{tiporelatoriodo.id}")
	public void update(TipoRelatorioDo tiporelatoriodo) {
		daoFactory.getTipoRelatorioDoDAO().update(tiporelatoriodo);
		result.redirectTo(this).tiporelatoriodoCrud();
	}
	
	@Delete @Path("/suporte/tiporelatoriodo/{tiporelatoriodo.id}")
	public void delete(TipoRelatorioDo tiporelatoriodo) {
		daoFactory.getTipoRelatorioDoDAO().delete(tiporelatoriodo);
		result.redirectTo(this).tiporelatoriodoCrud();
	}
	
	@Post @Path("/suporte/ano")
	public void add(Ano ano) {
		daoFactory.getAnoDAO().add(ano);
		result.redirectTo(this).anoCrud();
	}
	
	@Put @Path("/suporte/ano/{ano.id}")
	public void update(Ano ano) {
		daoFactory.getAnoDAO().update(ano);
		result.redirectTo(this).anoCrud();
	}
	
	@Delete @Path("/suporte/ano/{ano.id}")
	public void delete(Ano ano) {
		daoFactory.getAnoDAO().delete(ano);
		result.redirectTo(this).anoCrud();
	}
	
	@Post @Path("/suporte/foco")
	public void add(Foco foco) {
		daoFactory.getFocoDAO().add(foco);
		result.redirectTo(this).focoCrud();
	}
	
	@Put @Path("/suporte/foco/{foco.id}")
	public void update(Foco foco) {
		daoFactory.getFocoDAO().update(foco);
		result.redirectTo(this).focoCrud();
	}
	
	@Delete @Path("/suporte/foco/{foco.id}")
	public void delete(Foco foco) {
		daoFactory.getFocoDAO().delete(foco);
		result.redirectTo(this).focoCrud();
	}
	
	@Post @Path("/suporte/unidadeauditada")
	public void add(UnidadeAuditada unidadeauditada) {
		daoFactory.getUnidadeAuditadaDAO().add(unidadeauditada);
		result.redirectTo(this).unidadeauditadaCrud();
	}
	
	@Put @Path("/suporte/unidadeauditada/{unidadeauditada.id}")
	public void update(UnidadeAuditada unidadeauditada) {
		daoFactory.getUnidadeAuditadaDAO().update(unidadeauditada);
		result.redirectTo(this).unidadeauditadaCrud();
	}
	
	@Delete @Path("/suporte/unidadeauditada/{unidadeauditada.id}")
	public void delete(UnidadeAuditada unidadeauditada) {
		daoFactory.getUnidadeAuditadaDAO().delete(unidadeauditada);
		result.redirectTo(this).unidadeauditadaCrud();
	}

	@Post @Path("/suporte/natureza")
	public void add(Natureza natureza) {
		daoFactory.getNaturezaDAO().add(natureza);
		result.redirectTo(this).naturezaCrud();
	}
	
	@Put @Path("/suporte/natureza/{natureza.id}")
	public void update(Natureza natureza) {
		daoFactory.getNaturezaDAO().update(natureza);
		result.redirectTo(this).naturezaCrud();
	}
	
	@Delete @Path("/suporte/natureza/{natureza.id}")
	public void delete(Natureza natureza) {
		daoFactory.getNaturezaDAO().delete(natureza);
		result.redirectTo(this).naturezaCrud();
	}

	@Post @Path("/suporte/colegiado")
	public void add(Colegiado colegiado) {
		daoFactory.getColegiadoDAO().add(colegiado);
		result.redirectTo(this).colegiadoCrud();
	}
	
	@Put @Path("/suporte/colegiado/{colegiado.id}")
	public void update(Colegiado colegiado) {
		daoFactory.getColegiadoDAO().update(colegiado);
		result.redirectTo(this).colegiadoCrud();
	}
	
	@Delete @Path("/suporte/colegiado/{colegiado.id}")
	public void delete(Colegiado colegiado) {
		daoFactory.getColegiadoDAO().delete(colegiado);
		result.redirectTo(this).colegiadoCrud();
	}

	@Post @Path("/suporte/areatematica")
	public void add(AreaTematica areatematica) {
		daoFactory.getAreaTematicaDAO().add(areatematica);
		result.redirectTo(this).areatematicaCrud();
	}
	
	@Put @Path("/suporte/areatematica/{areatematica.id}")
	public void update(AreaTematica areatematica) {
		daoFactory.getAreaTematicaDAO().update(areatematica);
		result.redirectTo(this).areatematicaCrud();
	}
	
	@Delete @Path("/suporte/areatematica/{areatematica.id}")
	public void delete(AreaTematica areatematica) {
		daoFactory.getAreaTematicaDAO().delete(areatematica);
		result.redirectTo(this).areatematicaCrud();
	}

	@Post @Path("/suporte/unidade")
	public void add(Unidade unidade) {
		daoFactory.getUnidadeDAO().add(unidade);
		result.redirectTo(this).unidadeCrud();
	}
	
	@Put @Path("/suporte/unidade/{unidade.id}")
	public void update(Unidade unidade) {
		daoFactory.getUnidadeDAO().update(unidade);
		result.redirectTo(this).unidadeCrud();
	}
	
	@Delete @Path("/suporte/unidade/{unidade.id}")
	public void delete(Unidade unidade) {
		daoFactory.getUnidadeDAO().delete(unidade);
		result.redirectTo(this).unidadeCrud();
	}

	@Post @Path("/suporte/statusregistro")
	public void add(StatusRegistro statusregistro) {
		daoFactory.getStatusRegistroDAO().add(statusregistro);
		result.redirectTo(this).statusregistroCrud();
	}
	
	@Put @Path("/suporte/statusregistro/{statusregistro.id}")
	public void update(StatusRegistro statusregistro) {
		daoFactory.getStatusRegistroDAO().update(statusregistro);
		result.redirectTo(this).statusregistroCrud();
	}
	
	@Delete @Path("/suporte/statusregistro/{statusregistro.id}")
	public void delete(StatusRegistro statusregistro) {
		daoFactory.getStatusRegistroDAO().delete(statusregistro);
		result.redirectTo(this).statusregistroCrud();
	}

	
}
