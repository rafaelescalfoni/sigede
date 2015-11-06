package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.StatusRegistro;
import br.sigede.utils.componentes.UserSession;

@Resource
public class StatusRegistroController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public StatusRegistroController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/statusregistro/{statusregistroId}")
	public void cadastrar_statusregistro(Long statusregistroId) {
		StatusRegistro statusregistro = daoFactory.getStatusRegistroDAO().get(statusregistroId); //pesquisar o status do registro no bd
		result.include("statusregistro", statusregistro); //botar o status do registro a disposicao da jsp
	}	
}
