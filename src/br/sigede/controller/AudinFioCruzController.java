package br.sigede.controller;


import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
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
		//result.include("demandaList", daoFactory.getDemandaDAO().list());
		//result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		//result.include("tipodemandaList", daoFactory.getTipoDemandaDAO().list());
		//result.include("tiporelatorioaudinList", daoFactory.getTipoRelatorioAudinDAO().list());
		//result.include("anoList", daoFactory.getAnoDAO().list());
		//result.include("focoList", daoFactory.getFocoDAO().list());
		//result.include("unidadeauditadaList", daoFactory.getUnidadeAuditadaDAO().list());
		//result.include("areatematicaList", daoFactory.getAreaTematicaDAO().list());
		//result.include("unidadeList", daoFactory.getUnidadeDAO().list());
		//result.include("statusregistroList", daoFactory.getStatusRegistroDAO().list());
	}
	
	public void audinfiocruzCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	@Get("/audinfiocruz/cadastrar_audinfiocruz")
	public void cadastrar_audinfiocruz(){	
	}
	
	@Get @Path("/demandas/audinfiocruz/{demandaId}/update")
	public void edicao_audinfiocruz(Long demandaId){
	//	result.include("demanda", daoFactory.getDemandaDAO().get(demandaId));
	}
	
	@Get @Path("/demandas/audinfiocruz/{demandaId}/delete")
	public void audinfiocruzCrud(Long demandaId){
		
	}
	
	
	/////////////////////////////////////
	// metodos CRUD
	/////////////////////////////////////
	//@Post @Path("/demandas/audinfiocruz")
	//public void add(Demanda demanda) {
	//	daoFactory.getDemandaDAO().add(demanda);
	//	demanda.setData_acesso(new Date()); // cadastra a data e a hora atual
	//	result.redirectTo(this).audinfiocruzCrud();
	//}
	
	//@Put @Path("/demandas/audinfiocruz/{demanda.id}")
	//public void update(Demanda demanda) {
	//	daoFactory.getDemandaDAO().update(demanda);
	//	result.redirectTo(this).audinfiocruzCrud();
	//}


}
