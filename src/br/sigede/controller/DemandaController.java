package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Demanda;
import br.sigede.model.DemandaAudin;
import br.sigede.model.DemandaDo;
import br.sigede.model.DemandaTcu;
import br.sigede.utils.componentes.UserSession;

@Resource
public class DemandaController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
		
	public DemandaController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
		
	@Get("/demandas/audinfiocruz/{demanda.id}")
	public void cadastrar_audinfiocruz(Long demandaId) {
		
		Demanda demanda = daoFactory.getDemandaDAO().get(demandaId); //pesquisar a demanda no bd
		result.include("demanda", demanda); //botar a demanda a disposicao da jsp
		
		DemandaAudin demandaaudin = daoFactory.getDemandaAudinDAO().get(demandaId); //pesquisar a demanda AUDIN no bd
		result.include("demandaaudin", demandaaudin); //botar a demanda AUDIN a disposicao da jsp
		
	}	
	
	@Get("/demandas/tcu/{demanda.id}")
	public void cadastrar_tcu(Long demandaId) {
		
		Demanda demanda = daoFactory.getDemandaDAO().get(demandaId); //pesquisar a demanda no bd
		result.include("demanda", demanda); //botar a demanda a disposicao da jsp
		
		DemandaTcu demandatcu = daoFactory.getDemandaTcuDAO().get(demandaId); //pesquisar a demanda TCU no bd
		result.include("demandatcu", demandatcu); //botar a demanda TCU a disposicao da jsp
		
	}
	
	@Get("/demandas/do/{demanda.id}")
	public void cadastrar_do(Long demandaId) {
		
		Demanda demanda = daoFactory.getDemandaDAO().get(demandaId); //pesquisar a demanda no bd
		result.include("demanda", demanda); //botar a demanda a disposicao da jsp
		
		DemandaDo demandado = daoFactory.getDemandaDoDAO().get(demandaId); //pesquisar a demanda DO no bd
		result.include("demandado", demandado); //botar a demanda DO a disposicao da jsp
		
	}
	
}
