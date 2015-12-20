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
	// metodos de chamadas de página da demanda DO
	//////////////////////////////////////////////////////////////////
	
	//1º Abre o formulário de listagem das Demandas DO cadastradas
	@Get @Path("/demandas/do")
	public void doCrud() {
		System.out.println("\n\n1º Abre o formulário de listagem das Demandas DO cadastradas\n\n");
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

	//2º Abre o formulário de cadastro das Demandas DO
	@Get("/do/cadastrar_do")
	public void cadastrar_do() {
		System.out.println("\n\n2º Abre o formulário de cadastro da Demanda DO\n\n");
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

	//4º Abre o formulário de cadastro dos registros da Demanda DO salva anteriormente
	@Get @Path("/demandas/do/registro/{demandado.id}")
	public void cadastrar_do_registro(Long demandadoId) {
		System.out.println("\n\n4º Abre o formulário de cadastro do Registro da Demanda DO salva anteriormente\n\n");
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
	
	//6º Abre o formulário de cadastro dos novos registros da Demanda DO salva anteriormente
	@Get @Path("/demandas/do/registro/{demandadoId}/add")
	public void cadastrar_do_registro_novo(Long demandadoId) {
		System.out.println("\n\n6º Abre o formulário de cadastro do novo Registro da Demanda DO salva anteriormente\n\n");
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
	
	//8º Abre o formulário para edição do registro da Demanda DO
	@Get @Path("/demandas/do/registro/{demandadoId}/update")
	public void edicao_do_registro(Long demandadoId) {
		System.out.println("\n\n8º Abre o formulário para edição do registro da demanda DO\n\n");
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
	
	//3º Salva no banco de dados os dados contidos no formulário de cadastro das Demandas DO
	@Post @Path("/demandas/do")
	public void adiciona(DemandaDo demandado) {
		System.out.println("\n\n3º Salva a Demanda DO no Banco de Dados\n\n");
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date data_atual = new Date();
		demandado.setData_cadastro(formatador.format(data_atual)); // Salva em data_cadastro a data atual
		demandado.setUsuario(userSession.getUsuario()); //Salva em DemandaDo o usuário que efetuou a ação de cadastrar
		daoFactory.getDemandaDoDAO().add(demandado); //Salva os dados digitados pelo usuário na tabela DemandaDo
		userSession.setDemandado(demandado); //Salva a demandado na mesma sessão que o usuário
		result.redirectTo(this).cadastrar_do_registro(demandado.getId()); //Redireciona para o cadastro do RegistroDemandaDo
	}

	//5º Salva no banco de dados os dados contidos no formulário de cadastro do registro da Demanda DO
	@Post @Path("/demandas/do/registro/{demandado.id}")
	public void adiciona_registro(RegistroDemandaDo registrodemandado) {
		System.out.println("\n\n5º Salva o registro da Demanda DO no Banco de Dados\n\n");
		registrodemandado.setDemandado(userSession.getDemandado()); //Salva o ID da DemandaDo que está na sessão na tabela RegistroDemandaDo
		daoFactory.getRegistroDemandaDoDAO().add(registrodemandado); //Salva os dados digitados pelo usuário na tabela RegistroDemandaDo
		result.redirectTo(this).doCrud(); //Redireciona para o formulário de listagem das Demandas TCU cadastradas
	}

	//7º Salva no banco de dados os dados contidos no formulário de cadastro do novo registro da Demanda DO
	@Post @Path("/demandas/do/registro/{demandado.id}/add")
	public void adiciona_registro_novo(RegistroDemandaDo registrodemandado) {
		System.out.println("\n\n7º Salva o novo registro da Demanda DO no Banco de Dados\n\n");
		registrodemandado.setDemandado(userSession.getDemandado()); //Salva o ID da DemandaDo que está na sessão na tabela RegistroDemandaDo
		daoFactory.getRegistroDemandaDoDAO().add(registrodemandado); //Salva os dados digitados pelo usuário na tabela RegistroDemandaDo
		result.redirectTo(this).doCrud(); //Redireciona para o formulário de listagem das Demandas TCU cadastradas
	}

	//9º Salva no banco de dados os dados contidos no formulário de edição do registro da Demanda DO
	@Put @Path("/demandas/do/registro/{registrodemandado.id}")
	public void edicao_do_registro(RegistroDemandaDo registrodemandado) {
		System.out.println("\n\n9º Salva os dados contidos no formulário de edição do registro da Demanda DO no Banco de Dados\n\n");
		daoFactory.getRegistroDemandaDoDAO().update(registrodemandado);
		result.redirectTo(this).doCrud();
	}

	//10º Deleta os dados contidos no formulário de registro da Demanda DO do Banco de Dados
	@Delete @Path("/demandas/do/registro/{registrodemandado.id}")
	public void delete_registro(RegistroDemandaDo registrodemandado) {
		System.out.println("\n\n10º Deleta os dados contidos no formulário de registro da Demanda DO do Banco de Dados\n\n");
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
