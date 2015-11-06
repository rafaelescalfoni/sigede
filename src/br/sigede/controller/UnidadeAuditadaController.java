package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.UnidadeAuditada;
import br.sigede.utils.componentes.UserSession;

@Resource
public class UnidadeAuditadaController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public UnidadeAuditadaController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/unidadeauditada/{unidadeauditadaId}")
	public void cadastrar_unidadeauditada(Long unidadeauditadaId) {
		UnidadeAuditada unidadeauditada = daoFactory.getUnidadeAuditadaDAO().get(unidadeauditadaId); //pesquisar a unidade auditada no bd
		result.include("unidadeauditada", unidadeauditada); //botar a unidade auditada a disposicao da jsp
	}	
}
