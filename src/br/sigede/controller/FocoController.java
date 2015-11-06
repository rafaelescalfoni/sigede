package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Foco;
import br.sigede.utils.componentes.UserSession;

@Resource
public class FocoController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public FocoController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/foco/{focoId}")
	public void cadastrar_foco(Long focoId) {
		Foco foco = daoFactory.getFocoDAO().get(focoId); //pesquisar o foco da auditoria no bd
		result.include("foco", foco); //botar o foco da auditoria a disposicao da jsp
	}	
}
