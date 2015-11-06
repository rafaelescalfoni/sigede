package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.TipoRelatorioAudin;
import br.sigede.utils.componentes.UserSession;

@Resource
public class TipoRelatorioAudinController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
					
	public TipoRelatorioAudinController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
					
	@Get("/suporte/tiporelatorioaudin/{tiporelatorioaudinId}")
	public void cadastrar_tiporelatorioaudin(Long tiporelatorioaudinId) {
		TipoRelatorioAudin tiporelatorioaudin = daoFactory.getTipoRelatorioAudinDAO().get(tiporelatorioaudinId); //pesquisar o tipo de relatorio da audin no bd
		result.include("tiporelatorioaudin", tiporelatorioaudin); //botar o tipo de relatorio da audin a disposicao da jsp
	}
}
