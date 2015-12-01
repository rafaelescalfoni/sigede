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
		System.out.println("\n\n1º - listaCadastroTCU\n\n");
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
	
	//Caso ocorra algum erro no formulário de listagem das Demandas TCU, retorna a mensagem de erro
	public void tcuCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	//2º Abre o formulário de cadastro das Demandas TCU
	@Get("/tcu/cadastrar_tcu")
	public void cadastrar_tcu() {
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

	@Get @Path("/demandas/tcu/{demandatcuId}/update")
	public void edicao_tcu(Long demandatcuId) {
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
	
	//8º Abre o formulário para edição do registro da Demanda TCU
	@Get @Path("/demandas/tcu/registro/{demandatcuId}/update")
	public void edicao_tcu_registro(Long demandatcuId) {
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

	@Get @Path("/demandas/tcu/{demandatcuId}")
	public void deleta(Long demandatcuId) {
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

	
	
	/////////////////////////////////////
	// metodos CRUD
	/////////////////////////////////////
	
	//3º Salva no banco de dados os dados contidos no formulário de cadastro das Demandas TCU
	@Post @Path("/demandas/tcu")
	public void adiciona(DemandaTcu demandatcu) {
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
		registrodemandatcu.setDemandatcu(userSession.getDemandatcu()); //Salva o ID da DemandaTcu que está na sessão na tabela RegistroDemandaTcu
		daoFactory.getRegistroDemandaTcuDAO().add(registrodemandatcu); //Salva os dados digitados pelo usuário na tabela RegistroDemandaTcu
		result.redirectTo(this).tcuCrud(); //Redireciona para o formulário de listagem das Demandas TCU cadastradas
	}

	//7º Salva no banco de dados os dados contidos no formulário de cadastro do novo registro da Demanda TCU
	@Post @Path("/demandas/tcu/registro/{demandatcu.id}/add")
	public void adiciona_registro_novo(RegistroDemandaTcu registrodemandatcu) {
		registrodemandatcu.setDemandatcu(userSession.getDemandatcu()); //Salva o ID da DemandaTcu que está na sessão na tabela RegistroDemandaTcu
		daoFactory.getRegistroDemandaTcuDAO().add(registrodemandatcu); //Salva os dados digitados pelo usuário na tabela RegistroDemandaTcu
		result.redirectTo(this).tcuCrud(); //Redireciona para o formulário de listagem das Demandas TCU cadastradas
	}

	@Put @Path("/demandas/tcu/{demandatcu.id}/update")
	public void edicao_tcu(DemandaTcu demandatcu) {
		daoFactory.getDemandaTcuDAO().update(demandatcu);
		result.redirectTo(this).tcuCrud();
	}

	@Put @Path("/demandas/tcu/registro/{registrodemandatcu.id}/update")
	public void edicao_tcu_registro(RegistroDemandaTcu registrodemandatcu) {
		daoFactory.getRegistroDemandaTcuDAO().add(registrodemandatcu);
		result.redirectTo(this).tcuCrud();
	}

	@Delete @Path("/demandas/tcu/{demandatcu.id}")
	public void delete(DemandaTcu demandatcu, RegistroDemandaTcu registrodemandatcu) {
		daoFactory.getDemandaTcuDAO().delete(demandatcu);
		daoFactory.getRegistroDemandaTcuDAO().delete(registrodemandatcu);
		result.redirectTo(this).tcuCrud();
	}

	@Get
	@Path("/demandas/tcu/pesquisa")
	public void consulta_tcu(String palavraChave) {
		String strQuery = "FROM DemandaTcu dt " 
							+ "WHERE   dt.tipodemanda LIKE :trechoChave OR "
							+ " 	   dt.num_demanda LIKE :trechoChave OR "
							+ " 	   dt.ano LIKE :trechoChave OR " 
							+ " 	   dt.data_demanda LIKE :trechoChave OR "
							+ "	   	   dt.remetente LIKE :trechoChave OR " 
							+ "        dt.processotcu LIKE :trechoChave OR "
							+ "        dt.interessado LIKE :trechoChave OR " 
							+ "        dt.processo_interno LIKE :trechoChave OR "
							+ "        dt.naturezatcu LIKE :trechoChave OR "
							+ "        dt.num_acordao LIKE :trechoChave OR "
							+ "        dt.anoacordao LIKE :trechoChave OR "
							+ "        dt.colegiadoacordao LIKE :trechoChave OR "
							+ "        dt.data_sessaoacordao LIKE :trechoChave";
							//+ "      dt.areatematica LIKE :trechoChave OR "
							//+ "      dt.unidade LIKE :trechoChave OR " 
							//+ "      dt.assunto LIKE :trechoChave OR "
							//+ "      dt.desdobramento LIKE :trechoChave OR " 
							//+ "      dt.providencia LIKE :trechoChave OR "
							//+ "      dt.data_atualizacao LIKE :trechoChave OR " 
							//+ "      dt.statusregistro LIKE :trechoChave";

	    
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("trechoChave", "%" + palavraChave + "%");
		List<DemandaTcu> demandasEncontradas = daoFactory.getDemandaTcuDAO().list(strQuery, params);
		result.include("demandasEncontradas", demandasEncontradas);
	}
	
}
