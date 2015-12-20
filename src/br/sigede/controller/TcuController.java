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
import br.sigede.model.DemandaTcu;
import br.sigede.model.RegistroDemandaTcu;
import br.sigede.utils.componentes.AnoEnum;
import br.sigede.utils.componentes.AreaTematicaEnum;
import br.sigede.utils.componentes.ColegiadoEnum;
import br.sigede.utils.componentes.NaturezaTcuEnum;
import br.sigede.utils.componentes.StatusRegistroEnum;
import br.sigede.utils.componentes.TipoDemandaEnum;
import br.sigede.utils.componentes.UnidadeEnum;
import br.sigede.utils.componentes.UserSession;

@Resource
public class TcuController {
	// objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;

	public TcuController(Result result, UserSession userSession, DAOFactory daoFactory) {
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}

	//////////////////////////////////////////////////////////////////
	// metodos de chamadas de página da demanda da audin
	//////////////////////////////////////////////////////////////////
	
	//1º Abre o formulário de listagem das Demandas TCU cadastradas
	@Get @Path("/demandas/tcu")
	public void tcuCrud() {
		System.out.println("\n\n1º Abre o formulário de listagem das Demandas TCU cadastradas\n\n");
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("demandatcuList", daoFactory.getDemandaTcuDAO().list());
		result.include("registrodemandatcuList", daoFactory.getRegistroDemandaTcuDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("naturezatcuList", NaturezaTcuEnum.getList());
		result.include("anoacordaoList", AnoEnum.getList());
		result.include("colegiadoacordaoList", ColegiadoEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}
	
	//2º Abre o formulário de cadastro das Demandas TCU
	@Get("/tcu/cadastrar_tcu")
	public void cadastrar_tcu() {
		System.out.println("\n\n2º Abre o formulário de cadastro da Demanda TCU\n\n");
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("demandatcuList", daoFactory.getDemandaTcuDAO().list());
		result.include("registrodemandatcuList", daoFactory.getRegistroDemandaTcuDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("naturezatcuList", NaturezaTcuEnum.getList());
		result.include("anoacordaoList", AnoEnum.getList());
		result.include("colegiadoacordaoList", ColegiadoEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}

	//4º Abre o formulário de cadastro dos registros da Demanda TCU salva anteriormente
	@Get @Path("/demandas/tcu/registro/{demandatcu.id}")
	public void cadastrar_tcu_registro(Long demandatcuId) {
		System.out.println("\n\n4º Abre o formulário de cadastro do Registro da Demanda TCU salva anteriormente\n\n");
		result.include("demandatcu", daoFactory.getDemandaTcuDAO().get(demandatcuId));
		result.include("registrodemandatcu", daoFactory.getRegistroDemandaTcuDAO().get(demandatcuId));
		result.include("demandatcuList", daoFactory.getDemandaTcuDAO().list());
		result.include("registrodemandatcuList", daoFactory.getRegistroDemandaTcuDAO().list());
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("naturezatcuList", NaturezaTcuEnum.getList());
		result.include("anoacordaoList", AnoEnum.getList());
		result.include("colegiadoacordaoList", ColegiadoEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}
	
	//6º Abre o formulário de cadastro dos novos registros da Demanda TCU salva anteriormente
	@Get @Path("/demandas/tcu/registro/{demandatcuId}/add")
	public void cadastrar_tcu_registro_novo(Long demandatcuId) {
		System.out.println("\n\n6º Abre o formulário de cadastro do novo Registro da Demanda TCU salva anteriormente\n\n");
		result.include("demandatcu", daoFactory.getDemandaTcuDAO().get(demandatcuId));
		result.include("registrodemandatcu", daoFactory.getRegistroDemandaTcuDAO().get(demandatcuId));
		result.include("demandatcuList", daoFactory.getDemandaTcuDAO().list());
		result.include("registrodemandatcuList", daoFactory.getRegistroDemandaTcuDAO().list());
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("naturezatcuList", NaturezaTcuEnum.getList());
		result.include("anoacordaoList", AnoEnum.getList());
		result.include("colegiadoacordaoList", ColegiadoEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
		userSession.setDemandatcu(daoFactory.getDemandaTcuDAO().get(demandatcuId));
	}
	
	//8º Abre o formulário para edição do registro da Demanda TCU
	@Get @Path("/demandas/tcu/registro/{registrodemandatcuId}/update")
	public void edicao_tcu_registro(Long registrodemandatcuId) {
		System.out.println("\n\n8º Abre o formulário para edição do registro da demanda TCU\n\n");
		result.include("registrodemandatcu", daoFactory.getRegistroDemandaTcuDAO().get(registrodemandatcuId));
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("naturezatcuList", NaturezaTcuEnum.getList());
		result.include("anoacordaoList", AnoEnum.getList());
		result.include("colegiadoacordaoList", ColegiadoEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
	}

	
	
	/////////////////////////////////////
	// metodos CRUD
	/////////////////////////////////////
	
	//3º Salva no banco de dados os dados contidos no formulário de cadastro das Demandas TCU
	@Post @Path("/demandas/tcu")
	public void adiciona(DemandaTcu demandatcu) {
		System.out.println("\n\n3º Salva a Demanda TCU no Banco de Dados\n\n");
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date data_atual = new Date();
		demandatcu.setData_cadastro(formatador.format(data_atual)); // Salva em data_cadastro a data atual
		demandatcu.setUsuario(userSession.getUsuario()); //Salva em DemandaTcu o usuário que efetuou a ação de cadastrar
		daoFactory.getDemandaTcuDAO().add(demandatcu); //Salva os dados digitados pelo usuário na tabela DemandaTcu
		userSession.setDemandatcu(demandatcu); //Salva a demandatcu na mesma sessão que o usuário
		result.redirectTo(this).cadastrar_tcu_registro(demandatcu.getId()); //Redireciona para o cadastro do RegistroDemandaTcu
	}

	//5º Salva no banco de dados os dados contidos no formulário de cadastro do registro da Demanda TCU
	@Post @Path("/demandas/tcu/registro/{demandatcu.id}")
	public void adiciona_registro(RegistroDemandaTcu registrodemandatcu) {
		System.out.println("\n\n5º Salva o registro da Demanda TCU no Banco de Dados\n\n");
		registrodemandatcu.setDemandatcu(userSession.getDemandatcu()); //Salva o ID da DemandaTcu que está na sessão na tabela RegistroDemandaTcu
		daoFactory.getRegistroDemandaTcuDAO().add(registrodemandatcu); //Salva os dados digitados pelo usuário na tabela RegistroDemandaTcu
		result.redirectTo(this).tcuCrud(); //Redireciona para o formulário de listagem das Demandas TCU cadastradas
	}

	//7º Salva no banco de dados os dados contidos no formulário de cadastro do novo registro da Demanda TCU
	@Post @Path("/demandas/tcu/registro/{demandatcu.id}/add")
	public void adiciona_registro_novo(RegistroDemandaTcu registrodemandatcu) {
		System.out.println("\n\n7º Salva o novo registro da Demanda TCU no Banco de Dados\n\n");
		registrodemandatcu.setDemandatcu(userSession.getDemandatcu()); //Salva o ID da DemandaTcu que está na sessão na tabela RegistroDemandaTcu
		daoFactory.getRegistroDemandaTcuDAO().add(registrodemandatcu); //Salva os dados digitados pelo usuário na tabela RegistroDemandaTcu
		result.redirectTo(this).tcuCrud(); //Redireciona para o formulário de listagem das Demandas TCU cadastradas
	}
	
	//9º Salva no banco de dados os dados contidos no formulário de edição do registro da Demanda TCU
	@Put @Path("/demandas/tcu/registro/{registrodemandatcu.id}")
	public void edicao_tcu_registro(RegistroDemandaTcu registrodemandatcu) {
		System.out.println("\n\n9º Salva os dados contidos no formulário de edição do registro da Demanda TCU no Banco de Dados\n\n");
		daoFactory.getRegistroDemandaTcuDAO().update(registrodemandatcu);
		result.redirectTo(this).tcuCrud();
	}

	//10º Deleta os dados contidos no formulário de registro da Demanda TCU do Banco de Dados
	@Delete @Path("/demandas/tcu/registro/{registrodemandatcu.id}")
	public void delete_registro(RegistroDemandaTcu registrodemandatcu) {
		System.out.println("\n\n10º Deleta os dados contidos no formulário de registro da Demanda TCU do Banco de Dados\n\n");
		daoFactory.getRegistroDemandaTcuDAO().delete(registrodemandatcu);
		result.redirectTo(this).tcuCrud();
	}

	@Get
	@Path("/demanda/tcu/pesquisa")
	public void tcuCrud(String palavraChave) {
		String strQuery = "FROM RegistroDemandaTcu rdt " 
							+ "WHERE   rdt.demandatcu.tipodemanda LIKE :trechoChave OR "
							+ " 	   rdt.demandatcu.num_demanda LIKE :trechoChave OR "
							+ " 	   rdt.demandatcu.ano LIKE :trechoChave OR " 
							+ " 	   rdt.demandatcu.data_demanda LIKE :trechoChave OR "
							+ "	   	   rdt.demandatcu.remetente LIKE :trechoChave OR " 
							+ "        rdt.demandatcu.processotcu LIKE :trechoChave OR "
							+ "        rdt.demandatcu.interessado LIKE :trechoChave OR " 
							+ "        rdt.demandatcu.processo_interno LIKE :trechoChave OR "
							+ "        rdt.demandatcu.naturezatcu LIKE :trechoChave OR "
							+ "        rdt.demandatcu.num_acordao LIKE :trechoChave OR "
							+ "        rdt.demandatcu.anoacordao LIKE :trechoChave OR "
							+ "        rdt.demandatcu.colegiadoacordao LIKE :trechoChave OR "
							+ "        rdt.demandatcu.data_sessaoacordao LIKE :trechoChave OR "
							+ "        rdt.areatematica LIKE :trechoChave OR "
							+ "        rdt.unidade LIKE :trechoChave OR " 
							+ "        rdt.assunto LIKE :trechoChave OR "
							+ "        rdt.desdobramento LIKE :trechoChave OR " 
							+ "        rdt.providencia LIKE :trechoChave OR "
							+ "        rdt.data_atualizacao LIKE :trechoChave OR " 
							+ "        rdt.statusregistro LIKE :trechoChave";

	    
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("trechoChave", "%" + palavraChave + "%");
		List<RegistroDemandaTcu> demandasEncontradas = daoFactory.getRegistroDemandaTcuDAO().list(strQuery, params);
		result.include("demandasEncontradas", demandasEncontradas);
	}
	
}
