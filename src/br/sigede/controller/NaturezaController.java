package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Natureza;
import br.sigede.utils.componentes.UserSession;

@Resource
public class NaturezaController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public NaturezaController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/natureza/{naturezaId}")
	public void cadastrar_natureza(Long naturezaId) {
		Natureza natureza = daoFactory.getNaturezaDAO().get(naturezaId); //pesquisar a natureza no bd
		result.include("natureza", natureza); //botar a natureza a disposicao da jsp
	}	
}
