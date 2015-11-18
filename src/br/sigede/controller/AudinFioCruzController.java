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
import br.sigede.model.Demanda;
import br.sigede.model.DemandaAudin;
import br.sigede.model.RegistroDemanda;
import br.sigede.utils.componentes.AnoEnum;
import br.sigede.utils.componentes.AreaTematicaEnum;
import br.sigede.utils.componentes.InstitucionalEnum;
import br.sigede.utils.componentes.StatusRegistroEnum;
import br.sigede.utils.componentes.TipoDemandaEnum;
import br.sigede.utils.componentes.TipoRelatorioAudinEnum;
import br.sigede.utils.componentes.UnidadeEnum;
import br.sigede.utils.componentes.UserSession;


@Resource
public class AudinFiocruzController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
	
	public AudinFiocruzController(Result result, UserSession userSession, DAOFactory daoFactory) {
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
	
	//////////////////////////////////////////////////////////////////
	//metodos de chamadas de página da demanda da audin
	//////////////////////////////////////////////////////////////////
	@Get @Path("/demandas/audinfiocruz")
	public void audinfiocruzCrud(){		
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("demandaList", daoFactory.getDemandaDAO().list());
		result.include("demandaaudinList", daoFactory.getDemandaAudinDAO().list());
		result.include("registrodemandaList", daoFactory.getRegistroDemandaDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("tiporelatorioaudinList", TipoRelatorioAudinEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("institucionalList", InstitucionalEnum.getList());
		result.include("focoList", AreaTematicaEnum.getList());
		result.include("unidadeauditadaList", UnidadeEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}
	
	public void audinfiocruzCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	@Get("/audinfiocruz/cadastrar_audinfiocruz")
	public void cadastrar_audinfiocruz(){	
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("demandaList", daoFactory.getDemandaDAO().list());
		result.include("demandaaudinList", daoFactory.getDemandaAudinDAO().list());
		result.include("registrodemandaList", daoFactory.getRegistroDemandaDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("tiporelatorioaudinList", TipoRelatorioAudinEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("institucionalList", InstitucionalEnum.getList());
		result.include("focoList", AreaTematicaEnum.getList());
		result.include("unidadeauditadaList", UnidadeEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}
	
	@Get @Path("/demandas/audinfiocruz/{demandaId}/update")
	public void edicao_audinfiocruz(Long demandaId){
		result.include("demanda", daoFactory.getDemandaDAO().get(demandaId));
		result.include("demandaaudin", daoFactory.getDemandaAudinDAO().get(demandaId));
		result.include("registrodemanda", daoFactory.getRegistroDemandaDAO().get(demandaId));
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("tiporelatorioaudinList", TipoRelatorioAudinEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("institucionalList", InstitucionalEnum.getList());
		result.include("focoList", AreaTematicaEnum.getList());
		result.include("unidadeauditadaList", UnidadeEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}
	
	@Get @Path("/demandas/audinfiocruz/{demandaId}")
	public void deleta(Long demandaId){
		result.include("demanda", daoFactory.getDemandaDAO().get(demandaId));
		result.include("demandaaudin", daoFactory.getDemandaAudinDAO().get(demandaId));
		result.include("registrodemanda", daoFactory.getRegistroDemandaDAO().get(demandaId));
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("tiporelatorioaudinList", TipoRelatorioAudinEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("institucionalList", InstitucionalEnum.getList());
		result.include("focoList", AreaTematicaEnum.getList());
		result.include("unidadeauditadaList", UnidadeEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());		
	}
	
	
	/////////////////////////////////////
	// metodos CRUD
	/////////////////////////////////////
	@Post @Path("/demandas/audinfiocruz")
	public void add(Demanda demanda, DemandaAudin demandaaudin, RegistroDemanda registrodemanda) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date data_atual = new Date();
		demanda.setData_cadastro(formatador.format(data_atual));
		
		daoFactory.getDemandaDAO().add(demanda);
		daoFactory.getDemandaAudinDAO().add(demandaaudin);
		daoFactory.getRegistroDemandaDAO().add(registrodemanda);
		result.redirectTo(this).audinfiocruzCrud();
	}
	
	@Put @Path("/demandas/audinfiocruz/{demanda.id}")
	public void update(Demanda demanda, DemandaAudin demandaaudin, RegistroDemanda registrodemanda) {
		daoFactory.getDemandaDAO().update(demanda);
		daoFactory.getDemandaAudinDAO().update(demandaaudin);
		daoFactory.getRegistroDemandaDAO().update(registrodemanda);
		result.redirectTo(this).audinfiocruzCrud();
	}

	@Delete @Path("/demandas/audinfiocruz/{demanda.id}")
	public void delete(Demanda demanda, DemandaAudin demandaaudin, RegistroDemanda registrodemanda) {
		daoFactory.getDemandaDAO().delete(demanda);
		daoFactory.getDemandaAudinDAO().delete(demandaaudin);
		daoFactory.getRegistroDemandaDAO().delete(registrodemanda);
		result.redirectTo(this).audinfiocruzCrud();
	}
	

}
