package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.RegistroDemandaAudin;

@Resource
public class RegistroDemandaAudinController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final DAOFactory daoFactory;
		
	public RegistroDemandaAudinController(Result result, DAOFactory daoFactory){
		this.result = result;
		this.daoFactory = daoFactory;
	}
		
	@Get("/demandas/audinfiocruz/{demandaaudin.id}")
	public void cadastrar_audinfiocruz_registro(Long demandaaudinId) {
		System.out.println("\n\n13º\n\n");
		RegistroDemandaAudin registrodemandaaudin = daoFactory.getRegistroDemandaAudinDAO().get(demandaaudinId); //pesquisar o registro da demanda AUDIN no bd
		result.include("registrodemandaaudin", registrodemandaaudin); //botar o registro da demanda AUDIN a disposicao da jsp
		
	}
	
	@Get("/demandas/audinfiocruz/{demandaaudin.id}")
	public void cadastrar_audinfiocruz_registro_novo(Long demandaaudinId) {
		System.out.println("\n\n14º\n\n");
		RegistroDemandaAudin registrodemandaaudin = daoFactory.getRegistroDemandaAudinDAO().get(demandaaudinId); //pesquisar o registro da demanda AUDIN no bd
		result.include("registrodemandaaudin", registrodemandaaudin); //botar o registro da demanda AUDIN a disposicao da jsp
		
	}
	
	
}
