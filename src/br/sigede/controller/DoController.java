package br.sigede.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.sigede.dao.DAOFactory;
import br.sigede.model.DemandaDo;
import br.sigede.model.RegistroDemandaDo;
import br.sigede.utils.componentes.AnoEnum;
import br.sigede.utils.componentes.AreaTematicaEnum;
import br.sigede.utils.componentes.NaturezaDoEnum;
import br.sigede.utils.componentes.StatusRegistroEnum;
import br.sigede.utils.componentes.TipoDemandaDoEnum;
import br.sigede.utils.componentes.TipoRelatorioDoEnum;
import br.sigede.utils.componentes.UnidadeEnum;
import br.sigede.utils.componentes.UserSession;

@Resource
public class DoController {
	// objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;

	public DoController(Result result, UserSession userSession, DAOFactory daoFactory) {
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}

	//////////////////////////////////////////////////////////////////
	// metodos de chamadas de p�gina da demanda DO
	//////////////////////////////////////////////////////////////////
	
	//1� Abre o formul�rio de listagem das Demandas DO cadastradas
	@Get @Path("/demandas/do")
	public void doCrud() {
		System.out.println("\n\n1� Abre o formul�rio de listagem das Demandas DO cadastradas\n\n");
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("demandadoList", daoFactory.getDemandaDoDAO().list());
		result.include("registrodemandadoList", daoFactory.getRegistroDemandaDoDAO().list());
		result.include("tipodemandadoList", TipoDemandaDoEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("naturezadoList", NaturezaDoEnum.getList());
		result.include("tiporelatoriodoList", TipoRelatorioDoEnum.getList());
		result.include("exerciciorelatorioList", AnoEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}

	//2� Abre o formul�rio de cadastro das Demandas DO
	@Get("/do/cadastrar_do")
	public void cadastrar_do() {
		System.out.println("\n\n2� Abre o formul�rio de cadastro da Demanda DO\n\n");
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("demandadoList", daoFactory.getDemandaDoDAO().list());
		result.include("registrodemandadoList", daoFactory.getRegistroDemandaDoDAO().list());
		result.include("tipodemandadoList", TipoDemandaDoEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("naturezadoList", NaturezaDoEnum.getList());
		result.include("tiporelatoriodoList", TipoRelatorioDoEnum.getList());
		result.include("exerciciorelatorioList", AnoEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}

	//4� Abre o formul�rio de cadastro dos registros da Demanda DO salva anteriormente
	@Get @Path("/demandas/do/registro/{demandado.id}")
	public void cadastrar_do_registro(Long demandadoId) {
		System.out.println("\n\n4� Abre o formul�rio de cadastro do Registro da Demanda DO salva anteriormente\n\n");
		result.include("demandado", daoFactory.getDemandaDoDAO().get(demandadoId));
		result.include("registrodemandado", daoFactory.getRegistroDemandaDoDAO().get(demandadoId));
		result.include("demandadoList", daoFactory.getDemandaDoDAO().list());
		result.include("registrodemandadoList", daoFactory.getRegistroDemandaDoDAO().list());
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandadoList", TipoDemandaDoEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("naturezadoList", NaturezaDoEnum.getList());
		result.include("tiporelatoriodoList", TipoRelatorioDoEnum.getList());
		result.include("exerciciorelatorioList", AnoEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}
	
	//6� Abre o formul�rio de cadastro dos novos registros da Demanda DO salva anteriormente
	@Get @Path("/demandas/do/registro/{demandadoId}/add")
	public void cadastrar_do_registro_novo(Long demandadoId) {
		System.out.println("\n\n6� Abre o formul�rio de cadastro do novo Registro da Demanda DO salva anteriormente\n\n");
		result.include("demandado", daoFactory.getDemandaDoDAO().get(demandadoId));
		result.include("registrodemandado", daoFactory.getRegistroDemandaDoDAO().get(demandadoId));
		result.include("demandadoList", daoFactory.getDemandaDoDAO().list());
		result.include("registrodemandadoList", daoFactory.getRegistroDemandaDoDAO().list());
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandadoList", TipoDemandaDoEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("naturezadoList", NaturezaDoEnum.getList());
		result.include("tiporelatoriodoList", TipoRelatorioDoEnum.getList());
		result.include("exerciciorelatorioList", AnoEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
		userSession.setDemandado(daoFactory.getDemandaDoDAO().get(demandadoId));
	}
	
	//8� Abre o formul�rio para edi��o do registro da Demanda DO
	@Get @Path("/demandas/do/registro/{demandadoId}/update")
	public void edicao_do_registro(Long demandadoId) {
		System.out.println("\n\n8� Abre o formul�rio para edi��o do registro da demanda DO\n\n");
		result.include("registrodemandado", daoFactory.getRegistroDemandaDoDAO().get(demandadoId));
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandadoList", TipoDemandaDoEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("naturezadoList", NaturezaDoEnum.getList());
		result.include("tiporelatoriodoList", TipoRelatorioDoEnum.getList());
		result.include("exerciciorelatorioList", AnoEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}

		
	
	/////////////////////////////////////
	// metodos CRUD
	/////////////////////////////////////
	
	//3� Salva no banco de dados os dados contidos no formul�rio de cadastro das Demandas DO
	@Post @Path("/demandas/do")
	public void adiciona(DemandaDo demandado) {
		System.out.println("\n\n3� Salva a Demanda DO no Banco de Dados\n\n");
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date data_atual = new Date();
		demandado.setData_cadastro(formatador.format(data_atual)); // Salva em data_cadastro a data atual
		demandado.setUsuario(userSession.getUsuario()); //Salva em DemandaDo o usu�rio que efetuou a a��o de cadastrar
		daoFactory.getDemandaDoDAO().add(demandado); //Salva os dados digitados pelo usu�rio na tabela DemandaDo
		userSession.setDemandado(demandado); //Salva a demandado na mesma sess�o que o usu�rio
		result.redirectTo(this).cadastrar_do_registro(demandado.getId()); //Redireciona para o cadastro do RegistroDemandaDo
	}

	//5� Salva no banco de dados os dados contidos no formul�rio de cadastro do registro da Demanda DO
	@Post @Path("/demandas/do/registro/{demandado.id}")
	public void adiciona_registro(RegistroDemandaDo registrodemandado) {
		System.out.println("\n\n5� Salva o registro da Demanda DO no Banco de Dados\n\n");
		registrodemandado.setDemandado(userSession.getDemandado()); //Salva o ID da DemandaDo que est� na sess�o na tabela RegistroDemandaDo
		daoFactory.getRegistroDemandaDoDAO().add(registrodemandado); //Salva os dados digitados pelo usu�rio na tabela RegistroDemandaDo
		result.redirectTo(this).doCrud(); //Redireciona para o formul�rio de listagem das Demandas TCU cadastradas
	}

	//7� Salva no banco de dados os dados contidos no formul�rio de cadastro do novo registro da Demanda DO
	@Post @Path("/demandas/do/registro/{demandado.id}/add")
	public void adiciona_registro_novo(RegistroDemandaDo registrodemandado) {
		System.out.println("\n\n7� Salva o novo registro da Demanda DO no Banco de Dados\n\n");
		registrodemandado.setDemandado(userSession.getDemandado()); //Salva o ID da DemandaDo que est� na sess�o na tabela RegistroDemandaDo
		daoFactory.getRegistroDemandaDoDAO().add(registrodemandado); //Salva os dados digitados pelo usu�rio na tabela RegistroDemandaDo
		result.redirectTo(this).doCrud(); //Redireciona para o formul�rio de listagem das Demandas TCU cadastradas
	}

	//9� Salva no banco de dados os dados contidos no formul�rio de edi��o do registro da Demanda DO
	@Put @Path("/demandas/do/registro/{registrodemandado.id}")
	public void edicao_do_registro(RegistroDemandaDo registrodemandado) {
		System.out.println("\n\n9� Salva os dados contidos no formul�rio de edi��o do registro da Demanda DO no Banco de Dados\n\n");
		daoFactory.getRegistroDemandaDoDAO().update(registrodemandado);
		result.redirectTo(this).doCrud();
	}

	//10� Deleta os dados contidos no formul�rio de registro da Demanda DO do Banco de Dados
	@Delete @Path("/demandas/do/registro/{registrodemandado.id}")
	public void delete_registro(RegistroDemandaDo registrodemandado) {
		System.out.println("\n\n10� Deleta os dados contidos no formul�rio de registro da Demanda DO do Banco de Dados\n\n");
		daoFactory.getRegistroDemandaDoDAO().delete(registrodemandado);
		result.redirectTo(this).doCrud();
	}

	@Get
	@Path("/demanda/do/pesquisa")
	public void doCrud(String palavraChave) {
		String strQuery = "FROM RegistroDemandaDo rdo " 
							+ "WHERE   rdo.demandado.tipodemandado LIKE :trechoChave OR "
							+ " 	   rdo.demandado.num_demanda LIKE :trechoChave OR "
							+ " 	   rdo.demandado.ano LIKE :trechoChave OR " 
							+ " 	   rdo.demandado.data_demanda LIKE :trechoChave OR "
							+ "	   	   rdo.demandado.remetente LIKE :trechoChave OR " 
							+ "        rdo.demandado.interessado LIKE :trechoChave OR " 
							+ "        rdo.demandado.processo_interno LIKE :trechoChave OR "
							+ "        rdo.demandado.naturezado LIKE :trechoChave OR "
							+ " 	   rdo.demandado.tiporelatoriodo LIKE :trechoChave OR "
							+ "        rdo.demandado.num_relatorio LIKE :trechoChave OR "
							+ "        rdo.demandado.data_relatorio LIKE :trechoChave OR "
							+ "        rdo.demandado.exerciciorelatorio LIKE :trechoChave OR "
							+ "        rdo.areatematica LIKE :trechoChave OR "
							+ "        rdo.unidade LIKE :trechoChave OR " 
							+ "        rdo.assunto LIKE :trechoChave OR "
							+ "        rdo.desdobramento LIKE :trechoChave OR " 
							+ "        rdo.providencia LIKE :trechoChave OR "
							+ "        rdo.data_atualizacao LIKE :trechoChave OR " 
							+ "        rdo.statusregistro LIKE :trechoChave";

	    
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("trechoChave", "%" + palavraChave + "%");
		List<RegistroDemandaDo> demandasEncontradas = daoFactory.getRegistroDemandaDoDAO().list(strQuery, params);
		result.include("demandasEncontradas", demandasEncontradas);
	}

}
