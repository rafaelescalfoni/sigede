package br.sigede.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.utils.componentes.AnoEnum;
import br.sigede.utils.componentes.AreaTematicaEnum;
import br.sigede.utils.componentes.InstitucionalEnum;
import br.sigede.utils.componentes.StatusRegistroEnum;
import br.sigede.utils.componentes.TipoDemandaEnum;
import br.sigede.utils.componentes.TipoRelatorioAudinEnum;
import br.sigede.utils.componentes.UnidadeEnum;

@Resource
public class RelatorioController {
	// objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final DAOFactory daoFactory;

	public RelatorioController(Result result, DAOFactory daoFactory) {
		this.result = result;
		this.daoFactory = daoFactory;
	}

	//////////////////////////////////////////////////////////////////
	// metodos de chamadas de p�gina do relat�rio por �rea tem�tica
	//////////////////////////////////////////////////////////////////
	
	//1� Abre o formul�rio de relat�rio gerencial das demandas por �rea tem�tica
	@Get @Path("/relatorios/areatematica")
	public void por_areatematica() {
		System.out.println("\n\n1� - Relat�rio Por �rea Tem�tica\n\n");
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("demandaaudinList", daoFactory.getDemandaAudinDAO().list());
		result.include("registrodemandaaudinList", daoFactory.getRegistroDemandaAudinDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("tiporelatorioaudinList", TipoRelatorioAudinEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("institucionalList", InstitucionalEnum.getList());
		result.include("focoList", AreaTematicaEnum.getList());
		result.include("unidadeauditadaList", UnidadeEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}
	
	//Caso ocorra algum erro no formul�rio de relat�rio gerencial das demandas por �rea tem�tica, retorna a mensagem de erro
	public void por_areatematica(String msg) {
		result.include("mensagemErro", msg);
	}
	
	//2� Abre o formul�rio de relat�rio gerencial das demandas por unidade
	@Get @Path("/relatorios/unidade")
	public void por_unidade() {
		System.out.println("\n\n1� - Relat�rio Por Unidade\n\n");
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("demandaaudinList", daoFactory.getDemandaAudinDAO().list());
		result.include("registrodemandaaudinList", daoFactory.getRegistroDemandaAudinDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("tiporelatorioaudinList", TipoRelatorioAudinEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("institucionalList", InstitucionalEnum.getList());
		result.include("focoList", AreaTematicaEnum.getList());
		result.include("unidadeauditadaList", UnidadeEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}
	
	//Caso ocorra algum erro no formul�rio de relat�rio gerencial das demandas por unidade, retorna a mensagem de erro
	public void por_unidade(String msg) {
		result.include("mensagemErro", msg);
	}	
	
	//3� Abre o formul�rio de relat�rio gerencial das demandas por status do registro
	@Get @Path("/relatorios/statusregistro")
	public void por_statusregistro() {
		System.out.println("\n\n1� - Relat�rio Por Status do Relat�rio\n\n");
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("demandaaudinList", daoFactory.getDemandaAudinDAO().list());
		result.include("registrodemandaaudinList", daoFactory.getRegistroDemandaAudinDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("tiporelatorioaudinList", TipoRelatorioAudinEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("institucionalList", InstitucionalEnum.getList());
		result.include("focoList", AreaTematicaEnum.getList());
		result.include("unidadeauditadaList", UnidadeEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}
	
	//Caso ocorra algum erro no formul�rio de relat�rio gerencial das demandas por status do registro, retorna a mensagem de erro
	public void por_statusregistro(String msg) {
		result.include("mensagemErro", msg);
	}	

	

}
