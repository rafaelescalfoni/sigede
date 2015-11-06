package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.AreaTematica;
import br.sigede.utils.componentes.UserSession;

@Resource
public class AreaTematicaController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public AreaTematicaController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/areatematica/{areatematicaId}")
	public void cadastrar_areatematica(Long areatematicaId) {
		AreaTematica areatematica = daoFactory.getAreaTematicaDAO().get(areatematicaId); //pesquisar a área temática no bd
		result.include("areatematica", areatematica); //botar a área temática a disposicao da jsp
	}	
}
