package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.Area;
import br.sigede.utils.componentes.UserSession;

@Resource
public class AreaController {
	//objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;
			
	public AreaController(Result result, UserSession userSession, DAOFactory daoFactory){
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}
			
	@Get("/suporte/area/{areaId}")
	public void cadastrar_area(Long areaId) {
		Area area = daoFactory.getAreaDAO().get(areaId); //pesquisar a area no bd
		result.include("area", area); //botar a area a disposicao da jsp
	}	
}
