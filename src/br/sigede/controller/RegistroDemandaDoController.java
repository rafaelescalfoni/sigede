package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.RegistroDemandaDo;

@Resource
public class RegistroDemandaDoController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final DAOFactory daoFactory;
		
	public RegistroDemandaDoController(Result result, DAOFactory daoFactory){
		this.result = result;
		this.daoFactory = daoFactory;
	}
	
	@Get("/demandas/do/{demandado.id}")
	public void cadastrar_do_registro(Long demandadoId) {
		RegistroDemandaDo registrodemandado = daoFactory.getRegistroDemandaDoDAO().get(demandadoId); //pesquisar o registro da demanda DO no bd
		result.include("registrodemandado", registrodemandado); //botar o registro da demanda DO a disposicao da jsp
	}	
	
}
