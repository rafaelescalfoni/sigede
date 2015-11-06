package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Unidade;
import br.sigede.utils.componentes.UserSession;

@Resource
public class UnidadeController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public UnidadeController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/unidade/{unidadeId}")
	public void cadastrar_unidade(Long unidadeId) {
		Unidade unidade = daoFactory.getUnidadeDAO().get(unidadeId); //pesquisar a unidade no bd
		result.include("unidade", unidade); //botar a unidade a disposicao da jsp
	}	
}
