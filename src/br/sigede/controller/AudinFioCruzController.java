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
import br.sigede.model.DemandaAudin;
import br.sigede.model.RegistroDemandaAudin;
import br.sigede.utils.componentes.AnoEnum;
import br.sigede.utils.componentes.AreaTematicaEnum;
import br.sigede.utils.componentes.InstitucionalEnum;
import br.sigede.utils.componentes.StatusRegistroEnum;
import br.sigede.utils.componentes.TipoDemandaEnum;
import br.sigede.utils.componentes.TipoRelatorioAudinEnum;
import br.sigede.utils.componentes.UnidadeEnum;
import br.sigede.utils.componentes.UserSession;

@Resource
public class AudinFiocruzController {
	// objetos que serao injetados automaticamente pelo vraptor
	// (para isto, as classes devem estar anotadas com @Component)
	private final Result result;
	private final UserSession userSession;
	private final DAOFactory daoFactory;

	public AudinFiocruzController(Result result, UserSession userSession, DAOFactory daoFactory) {
		this.result = result;
		this.userSession = userSession;
		this.daoFactory = daoFactory;
	}

	//////////////////////////////////////////////////////////////////
	// metodos de chamadas de p�gina da demanda da audin
	//////////////////////////////////////////////////////////////////
	
	//1� Abre o formul�rio de listagem das Demandas AUDIN cadastradas
	@Get @Path("/demandas/audinfiocruz")
	public void audinfiocruzCrud() {
		System.out.println("\n\n1� - listaCadastro\n\n");
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
	
	//Caso ocorra algum erro no formul�rio de listagem das Demandas AUDIN, retorna a mensagem de erro
	public void audinfiocruzCrud(String msg) {
		result.include("mensagemErro", msg);
	}
	
	//2� Abre o formul�rio de cadastro das Demandas AUDIN
	@Get("/audinfiocruz/cadastrar_audinfiocruz")
	public void cadastrar_audinfiocruz() {
		System.out.println("\n\n2� Abre a tela de cadastro da Demanda AUDIN\n\n");
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
	
	//4� Abre o formul�rio de cadastro dos registros da Demanda AUDIN salva anteriormente
	@Get @Path("/demandas/audinfiocruz/registro/{demandaaudin.id}")
	public void cadastrar_audinfiocruz_registro(Long demandaaudinId) {
		System.out.println("\n\n4� tela de cadastro do Registro da Demanda AUDIN salva anteriormente\n\n");
		result.include("demandaaudin", daoFactory.getDemandaAudinDAO().get(demandaaudinId));
		result.include("registrodemandaaudin", daoFactory.getRegistroDemandaAudinDAO().get(demandaaudinId));
		result.include("demandaaudinList", daoFactory.getDemandaAudinDAO().list());
		result.include("registrodemandaaudinList", daoFactory.getRegistroDemandaAudinDAO().list());
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
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

	//6� Abre o formul�rio de cadastro dos novos registros da Demanda AUDIN salva anteriormente
	@Get @Path("/demandas/audinfiocruz/registro/{demandaaudinId}/add")
	public void cadastrar_audinfiocruz_registro_novo(Long demandaaudinId) {
		System.out.println("\n\n6� tela de cadastro do novo Registro da Demanda AUDIN salva anteriormente\n\n");
		result.include("demandaaudin", daoFactory.getDemandaAudinDAO().get(demandaaudinId));
		result.include("registrodemandaaudin", daoFactory.getRegistroDemandaAudinDAO().get(demandaaudinId));
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("tiporelatorioaudinList", TipoRelatorioAudinEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("institucionalList", InstitucionalEnum.getList());
		result.include("focoList", AreaTematicaEnum.getList());
		result.include("unidadeauditadaList", UnidadeEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
		userSession.setDemandaaudin(daoFactory.getDemandaAudinDAO().get(demandaaudinId));
	}
	
	//8.1� Abre o formul�rio para edi��o da Demanda AUDIN
	@Get @Path("/demandas/audinfiocruz/{demandaaudinId}/update")
	public void edicao_audinfiocruz(Long demandaaudinId) {
		System.out.println("\n\n8.1� Abre o formul�rio para edi��o da Demanda AUDIN\n\n");
		result.include("demandaaudin", daoFactory.getDemandaAudinDAO().get(demandaaudinId));
		result.include("registrodemandaaudin", daoFactory.getRegistroDemandaAudinDAO().get(demandaaudinId));
		result.include("demandaaudinList", daoFactory.getDemandaAudinDAO().list());
		result.include("registrodemandaaudinList", daoFactory.getRegistroDemandaAudinDAO().list());
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("tiporelatorioaudinList", TipoRelatorioAudinEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("institucionalList", InstitucionalEnum.getList());
		result.include("focoList", AreaTematicaEnum.getList());
		result.include("unidadeauditadaList", UnidadeEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
		userSession.setDemandaaudin(daoFactory.getDemandaAudinDAO().get(demandaaudinId));
	}
	
	//8.2� Abre o formul�rio para edi��o do registro da Demanda AUDIN
	@Get @Path("/demandas/audinfiocruz/registro/{registrodemandaaudinId}/update")
	public void edicao_audinfiocruz_registro(Long registrodemandaaudinId) {
		System.out.println("\n\n8.2� Abre o formul�rio para edi��o do registro da demanda AUDIN");
		result.include("demandaaudin", daoFactory.getDemandaAudinDAO().get(registrodemandaaudinId));
		result.include("registrodemandaaudin", daoFactory.getRegistroDemandaAudinDAO().get(registrodemandaaudinId));
		result.include("usuarioList", daoFactory.getUsuarioDAO().list());
		result.include("tipodemandaList", TipoDemandaEnum.getList());
		result.include("tiporelatorioaudinList", TipoRelatorioAudinEnum.getList());
		result.include("anoList", AnoEnum.getList());
		result.include("institucionalList", InstitucionalEnum.getList());
		result.include("focoList", AreaTematicaEnum.getList());
		result.include("unidadeauditadaList", UnidadeEnum.getList());
		result.include("areatematicaList", AreaTematicaEnum.getList());
		result.include("unidadeList", UnidadeEnum.getList());
		result.include("statusregistroList", StatusRegistroEnum.getList());
		userSession.setDemandaaudin(daoFactory.getDemandaAudinDAO().get(registrodemandaaudinId));
	}


	
	
	/////////////////////////////////////
	// metodos CRUD
	/////////////////////////////////////
	
	//3� Salva no banco de dados os dados contidos no formul�rio de cadastro das Demandas AUDIN 
	@Post @Path("/demandas/audinfiocruz")
	public void adiciona(DemandaAudin demandaaudin) {
		System.out.println("\n\n3� Salva a Demanda AUDIN\n\n");
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		Date data_atual = new Date();
		demandaaudin.setData_cadastro(formatador.format(data_atual)); // Salva em data_cadastro a data atual
		demandaaudin.setUsuario(userSession.getUsuario()); //Salva em DemandaAudin o usu�rio que efetuou a a��o de cadastrar
		String tipodemandaaudin = "Relat�rio"; //Relat�rio � a �nica demanda da AUDIN
		demandaaudin.setTipodemanda(tipodemandaaudin); //Salva Relat�rio como tipodemanda em DemandaAudin
		daoFactory.getDemandaAudinDAO().add(demandaaudin); //Salva os dados digitados pelo usu�rio na tabela DemandaAudin
		userSession.setDemandaaudin(demandaaudin); //Salva a demandaaudin na mesma sess�o que o usu�rio
		result.redirectTo(this).cadastrar_audinfiocruz_registro(demandaaudin.getId());//Redireciona para o cadastro do RegistroDemandaAudin
	}
	
	//5� Salva no banco de dados os dados contidos no formul�rio de cadastro do registro da Demanda AUDIN
	@Post @Path("/demandas/audinfiocruz/registro/{demandaaudin.id}")
	public void adiciona_registro(RegistroDemandaAudin registrodemandaaudin) {
		System.out.println("\n\n5� Salva o registro da Demanda AUDIN " + userSession.getDemandaaudin());
		registrodemandaaudin.setDemandaaudin(userSession.getDemandaaudin()); //Salva o ID da DemandaAudin que est� na sess�o na tabela RegistroDemandaAudin
		daoFactory.getRegistroDemandaAudinDAO().add(registrodemandaaudin); //Salva os dados digitados pelo usu�rio na tabela RegistroDemandaAudin
		result.redirectTo(this).audinfiocruzCrud(); //Redireciona para o formul�rio de listagem das Demandas AUDIN cadastradas
	}
	
	//7� Salva no banco de dados os dados contidos no formul�rio de cadastro do novo registro da Demanda AUDIN
	@Post @Path("/demandas/audinfiocruz/registro/{demandaaudin.id}/add")
	public void adiciona_registro_novo(RegistroDemandaAudin registrodemandaaudin) {
		System.out.println("\n\n7� Salva o registro da Demanda AUDIN " + userSession.getDemandaaudin());
		registrodemandaaudin.setDemandaaudin(userSession.getDemandaaudin()); //Salva o ID da DemandaAudin que est� na sess�o na tabela RegistroDemandaAudin
		daoFactory.getRegistroDemandaAudinDAO().add(registrodemandaaudin); //Salva os dados digitados pelo usu�rio na tabela RegistroDemandaAudin
		result.redirectTo(this).audinfiocruzCrud(); //Redireciona para o formul�rio de listagem das Demandas AUDIN cadastradas
	}

	@Put @Path("/demandas/audinfiocruz/{demandaaudin.id}")
	public void edicao_audinfiocruz(DemandaAudin demandaaudin) {
		System.out.println("\n\n9�\n\n");
		daoFactory.getDemandaAudinDAO().update(demandaaudin);
		result.redirectTo(this).audinfiocruzCrud();
	}

	@Put @Path("/demandas/audinfiocruz/registro/{registrodemandaaudin.id}")
	public void edicao_audinfiocruz_registro(RegistroDemandaAudin registrodemandaaudin) {
		System.out.println("\n\n10�\n\n");
		daoFactory.getRegistroDemandaAudinDAO().update(registrodemandaaudin);
		result.redirectTo(this).audinfiocruzCrud();
	}

	@Delete @Path("/demandas/audinfiocruz/{demandaaudin.id}")
	public void delete(DemandaAudin demandaaudin) {
		System.out.println("\n\n11.1�\n\n");
		daoFactory.getDemandaAudinDAO().delete(demandaaudin);
		result.redirectTo(this).audinfiocruzCrud();
	}
	
	@Delete @Path("/demandas/audinfiocruz/registro/{registrodemandaaudin.id}")
	public void delete_registro(RegistroDemandaAudin registrodemandaaudin) {
		System.out.println("\n\n11.2�\n\n");
		daoFactory.getRegistroDemandaAudinDAO().delete(registrodemandaaudin);
		result.redirectTo(this).audinfiocruzCrud();
	}

	@Get
	@Path("/demandas/audinfiocruz/pesquisa")
	public void consulta_audinfiocruz(String palavraChave) {
		System.out.println("\n\nFaz consulta...");
		String strQuery = "FROM DemandaAudin da " 
							+ "WHERE   rda.da.tipodemanda LIKE :trechoChave OR "
							+ " 	   rda.da.tiporelatorioaudin LIKE :trechoChave OR " 
							+ " 	   rda.da.num_demanda LIKE :trechoChave OR "
							+ " 	   rda.da.ano LIKE :trechoChave OR " 
							+ " 	   rda.da.data_inicio LIKE :trechoChave OR "
							+ "	   	   rda.da.data_fim LIKE :trechoChave OR " 
							+ "        rda.da.processo_interno LIKE :trechoChave OR "
							+ "        rda.da.institucional LIKE :trechoChave OR " 
							+ "        rda.da.foco LIKE :trechoChave OR "
							+ "        rda.da.unidadeauditada LIKE :trechoChave OR "
							+ "        rda.areatematica LIKE :trechoChave OR "
							+ "        rda.unidade LIKE :trechoChave OR " 
							+ "        rda.assunto LIKE :trechoChave OR "
							+ "        rda.desdobramento LIKE :trechoChave OR " 
							+ "        rda.providencia LIKE :trechoChave OR "
							+ "        rda.data_atualizacao LIKE :trechoChave OR " 
							+ "        rda.statusregistro LIKE :trechoChave";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("trechoChave", "%" + palavraChave + "%");
		List<RegistroDemandaAudin> demandasEncontradas = daoFactory.getRegistroDemandaAudinDAO().list(strQuery, params);
		//List<RegistroDemandaAudin> registrodemandasEncontradas = daoFactory.getRegistroDemandaAudinDAO().list(strQuery, params);
		result.include("demandasEncontradas", demandasEncontradas);
		//result.include("demandasEncontradas", registrodemandasEncontradas);
	}

}
