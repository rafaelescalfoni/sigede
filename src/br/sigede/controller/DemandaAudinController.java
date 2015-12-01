package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.DemandaAudin;

@Resource
public class DemandaAudinController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final DAOFactory daoFactory;
		
	public DemandaAudinController(Result result, DAOFactory daoFactory){
		this.result = result;
		this.daoFactory = daoFactory;
	}
		
	@Get("/demandas/audinfiocruz/{demandaaudin.id}")
	public void cadastrar_audinfiocruz(Long demandaaudinId) {
		System.out.println("\n\n12º\n\n");
		DemandaAudin demandaaudin = daoFactory.getDemandaAudinDAO().get(demandaaudinId); //pesquisar a demanda AUDIN no bd
		result.include("demandaaudin", demandaaudin); //botar a demanda AUDIN a disposicao da jsp
	}	
	
	
}
