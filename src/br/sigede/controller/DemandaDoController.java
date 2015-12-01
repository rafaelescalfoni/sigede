package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.DemandaDo;

@Resource
public class DemandaDoController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final DAOFactory daoFactory;
		
	public DemandaDoController(Result result, DAOFactory daoFactory){
		this.result = result;
		this.daoFactory = daoFactory;
	}
	
	@Get("/demandas/do/{demandado.id}")
	public void cadastrar_do(Long demandadoId) {
		DemandaDo demandado = daoFactory.getDemandaDoDAO().get(demandadoId); //pesquisar a demanda DO no bd
		result.include("demandado", demandado); //botar a demanda DO a disposicao da jsp
	}
	
}
