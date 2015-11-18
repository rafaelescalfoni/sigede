package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.RegistroDemanda;
import br.sigede.utils.componentes.UserSession;

@Resource
public class RegistroDemandaController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
		
	public RegistroDemandaController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
		
	@Get("/demandas/audinfiocruz/{demanda.id}")
	public void cadastrar_audinfiocruz_registro(Long demandaId) {
		RegistroDemanda registrodemanda = daoFactory.getRegistroDemandaDAO().get(demandaId); //pesquisar o registro da demanda no bd
		result.include("registrodemanda", registrodemanda); //botar o registro da demanda a disposicao da jsp
	}
	
	@Get("/demandas/tcu/{demanda.id}")
	public void cadastrar_tcu_registro(Long demandaId) {
		RegistroDemanda registrodemanda = daoFactory.getRegistroDemandaDAO().get(demandaId); //pesquisar o registro da demanda no bd
		result.include("registrodemanda", registrodemanda); //botar o registro da demanda a disposicao da jsp
	}	
	
	@Get("/demandas/do/{demanda.id}")
	public void cadastrar_do_registro(Long demandaId) {
		RegistroDemanda registrodemanda = daoFactory.getRegistroDemandaDAO().get(demandaId); //pesquisar o registro da demanda no bd
		result.include("registrodemanda", registrodemanda); //botar o registro da demanda a disposicao da jsp
	}	
	
}
