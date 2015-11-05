package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.TipoDemanda;
import br.sigede.utils.componentes.UserSession;

@Resource
public class TipoDemandaController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public TipoDemandaController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/tipodemanda/{tipodemandaId}")
	public void cadastrar_tipodemanda(Long tipodemandaId) {
		TipoDemanda tipoDemanda = daoFactory.getTipoDemandaDAO().get(tipodemandaId); //pesquisar o tipo de demanda no bd
		result.include("tipodemanda", tipoDemanda); //botar o tipo de demanda a disposicao da jsp
	}	
}
