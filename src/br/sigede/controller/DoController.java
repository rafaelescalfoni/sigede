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
	
	//Caso ocorra algum erro no formulário de listagem das Demandas DO, retorna a mensagem de erro
	public void doCrud(String msg) {
		result.include("mensagemErro", msg);
	}

	//2º Abre o formulário de cadastro das Demandas DO
	@Get("/do/cadastrar_do")
	public void cadastrar_do() {
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

	@Get @Path("/demandas/do/{demandaId}/update")
	public void edicao_do(Long demandaId) {
		result.include("demandado", daoFactory.getDemandaDoDAO().get(demandaId));
		result.include("registrodemandado", daoFactory.getRegistroDemandaDoDAO().get(demandaId));
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
	
	//8º Abre o formulário para edição do registro da Demanda DO
	@Get @Path("/demandas/do/registro/{demandadoId}/update")
	public void edicao_do_registro(Long demandadoId) {
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

	@Get @Path("/demandas/do/{demandaId}")
	public void deleta(Long demandaId) {
		result.include("demandado", daoFactory.getDemandaDoDAO().get(demandaId));
		result.include("registrodemandado", daoFactory.getRegistroDemandaDoDAO().get(demandaId));
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

	
	
	/////////////////////////////////////
	// metodos CRUD
	/////////////////////////////////////
	
	//3º Salva no banco de dados os dados contidos no formulário de cadastro das Demandas DO
	@Post @Path("/demandas/do")
	public void add(DemandaDo demandado) {
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
	public void add_registro(RegistroDemandaDo registrodemandado) {
		registrodemandado.setDemandado(userSession.getDemandado()); //Salva o ID da DemandaDo que está na sessão na tabela RegistroDemandaDo
		daoFactory.getRegistroDemandaDoDAO().add(registrodemandado); //Salva os dados digitados pelo usuário na tabela RegistroDemandaDo
		result.redirectTo(this).doCrud(); //Redireciona para o formulário de listagem das Demandas TCU cadastradas
	}

	//7º Salva no banco de dados os dados contidos no formulário de cadastro do novo registro da Demanda DO
	@Post @Path("/demandas/do/registro/{demandado.id}/add")
	public void add_registro_novo(RegistroDemandaDo registrodemandado) {
		registrodemandado.setDemandado(userSession.getDemandado()); //Salva o ID da DemandaDo que está na sessão na tabela RegistroDemandaDo
		daoFactory.getRegistroDemandaDoDAO().add(registrodemandado); //Salva os dados digitados pelo usuário na tabela RegistroDemandaDo
		result.redirectTo(this).doCrud(); //Redireciona para o formulário de listagem das Demandas TCU cadastradas
	}
	
	@Put @Path("/demandas/do/{demandado.id}")
	public void update(DemandaDo demandado, RegistroDemandaDo registrodemandado) {
		daoFactory.getDemandaDoDAO().update(demandado);
		daoFactory.getRegistroDemandaDoDAO().update(registrodemandado);
		result.redirectTo(this).doCrud();
	}

	@Put @Path("/demandas/do/registro/{demandado.id}")
	public void update_registro(DemandaDo demandado, RegistroDemandaDo registrodemandado) {
		daoFactory.getDemandaDoDAO().update(demandado);
		daoFactory.getRegistroDemandaDoDAO().add(registrodemandado);
		result.redirectTo(this).doCrud();
	}

	@Delete @Path("/demandas/do/{demandado.id}")
	public void delete(DemandaDo demandado, RegistroDemandaDo registrodemandado) {
		daoFactory.getDemandaDoDAO().delete(demandado);
		daoFactory.getRegistroDemandaDoDAO().delete(registrodemandado);
		result.redirectTo(this).doCrud();
	}

	@Get
	@Path("/demandas/do/pesquisa")
	public void consulta_do(String palavraChave) {
		String strQuery = "FROM DemandaDo do " 
							+ "WHERE   do.tipodemandado LIKE :trechoChave OR "
							+ " 	   do.num_demanda LIKE :trechoChave OR "
							+ " 	   do.ano LIKE :trechoChave OR " 
							+ " 	   do.data_demanda LIKE :trechoChave OR "
							+ "	   	   do.remetente LIKE :trechoChave OR " 
							+ "        do.interessado LIKE :trechoChave OR " 
							+ "        do.processo_interno LIKE :trechoChave OR "
							+ "        do.naturezado LIKE :trechoChave OR "
							+ " 	   do.tiporelatoriodo LIKE :trechoChave OR "
							+ "        do.num_relatorio LIKE :trechoChave OR "
							+ "        do.data_relatorio LIKE :trechoChave OR "
							+ "        do.exerciciorelatorio LIKE :trechoChave";
							//+ "      do.areatematica LIKE :trechoChave OR "
							//+ "      do.unidade LIKE :trechoChave OR " 
							//+ "      do.assunto LIKE :trechoChave OR "
							//+ "      do.desdobramento LIKE :trechoChave OR " 
							//+ "      do.providencia LIKE :trechoChave OR "
							//+ "      do.data_atualizacao LIKE :trechoChave OR " 
							//+ "      do.statusregistro LIKE :trechoChave";

	    
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("trechoChave", "%" + palavraChave + "%");
		List<DemandaDo> demandasEncontradas = daoFactory.getDemandaDoDAO().list(strQuery, params);
		result.include("demandasEncontradas", demandasEncontradas);
	}

}
