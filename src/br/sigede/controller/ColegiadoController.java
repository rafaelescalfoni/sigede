package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Colegiado;
import br.sigede.utils.componentes.UserSession;

@Resource
public class ColegiadoController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public ColegiadoController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/colegiado/{colegiadoId}")
	public void cadastrar_colegiado(Long colegiadoId) {
		Colegiado colegiado = daoFactory.getColegiadoDAO().get(colegiadoId); //pesquisar o colegiado no bd
		result.include("colegiado", colegiado); //botar o colegiado a disposicao da jsp
	}	
}
