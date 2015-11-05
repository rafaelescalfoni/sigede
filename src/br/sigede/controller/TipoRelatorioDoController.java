package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.TipoRelatorioDo;
import br.sigede.utils.componentes.UserSession;

@Resource
public class TipoRelatorioDoController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public TipoRelatorioDoController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/tiporelatoriodo/{tiporelatoriodoId}")
	public void cadastrar_tiporelatoriodo(Long tiporelatoriodoId) {
		TipoRelatorioDo tipoRelatorioDo = daoFactory.getTipoRelatorioDoDAO().get(tiporelatoriodoId); //pesquisar o tipo de relatorio dos demais órgãos no bd
		result.include("tiporelatoriodo", tipoRelatorioDo); //botar o tipo de relatorio dos demais órgãos a disposicao da jsp
	}	
}
