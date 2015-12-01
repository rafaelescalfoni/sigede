package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.RegistroDemandaTcu;

@Resource
public class RegistroDemandaTcuController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final DAOFactory daoFactory;
		
	public RegistroDemandaTcuController(Result result, DAOFactory daoFactory){
		this.result = result;
		this.daoFactory = daoFactory;
	}
	
	@Get("/demandas/tcu/{demandatcu.id}")
	public void cadastrar_tcu_registro(Long demandatcuId) {
		RegistroDemandaTcu registrodemandatcu = daoFactory.getRegistroDemandaTcuDAO().get(demandatcuId); //pesquisar o registro da demanda TCU no bd
		result.include("registrodemandatcu", registrodemandatcu); //botar o registro da demanda TCU a disposicao da jsp
	}	
	
}
