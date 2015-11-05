package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Status;
import br.sigede.utils.componentes.UserSession;

@Resource
public class StatusController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
	
	public StatusController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
	
	@Get("/suporte/status/{statusId}")
	public void cadastrar_status(Long statusId) {
		Status status = daoFactory.getStatusDAO().get(statusId); //pesquisar o status do usuário no bd
		result.include("status", status); //botar o status do usuário a disposicao da jsp
	}
	
}
