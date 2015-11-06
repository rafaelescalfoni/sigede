package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Ano;
import br.sigede.utils.componentes.UserSession;

@Resource
public class AnoController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public AnoController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/ano/{anoId}")
	public void cadastrar_ano(Long anoId) {
		Ano ano = daoFactory.getAnoDAO().get(anoId); //pesquisar o ano no bd
		result.include("ano", ano); //botar o ano a disposicao da jsp
	}	
}
