package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.DemandaTcu;

@Resource
public class DemandaTcuController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final DAOFactory daoFactory;
		
	public DemandaTcuController(Result result, DAOFactory daoFactory){
		this.result = result;
		this.daoFactory = daoFactory;
	}
	
	@Get("/demandas/tcu/{demandatcu.id}")
	public void cadastrar_tcu(Long demandatcuId) {
		DemandaTcu demandatcu = daoFactory.getDemandaTcuDAO().get(demandatcuId); //pesquisar a demanda TCU no bd
		result.include("demandatcu", demandatcu); //botar a demanda TCU a disposicao da jsp
	}
	
	
}
