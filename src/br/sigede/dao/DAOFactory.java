package br.sigede.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.sigede.model.Ano;
import br.sigede.model.Area;
import br.sigede.model.AreaTematica;
import br.sigede.model.Colegiado;
import br.sigede.model.Foco;
import br.sigede.model.Natureza;
import br.sigede.model.Status;
import br.sigede.model.StatusRegistro;
import br.sigede.model.TipoDemanda;
import br.sigede.model.TipoRelatorioAudin;
import br.sigede.model.TipoRelatorioDo;
import br.sigede.model.Unidade;
import br.sigede.model.UnidadeAuditada;
import br.sigede.model.Usuario;


@Component
public class DAOFactory {

	private EntityManager em;

	public DAOFactory(EntityManager em) {
		this.em = em;
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO(this.em, Usuario.class);
	}
	
	public AreaDAO getAreaDAO() {
		return new AreaDAO(this.em, Area.class);
	}
	
	public StatusDAO getStatusDAO() {
		return new StatusDAO(this.em, Status.class);
	}
	
	public TipoDemandaDAO getTipoDemandaDAO() {
		return new TipoDemandaDAO(this.em, TipoDemanda.class);
	}
	
	public TipoRelatorioAudinDAO getTipoRelatorioAudinDAO() {
		return new TipoRelatorioAudinDAO(this.em, TipoRelatorioAudin.class);
	}
	
	public TipoRelatorioDoDAO getTipoRelatorioDoDAO() {
		return new TipoRelatorioDoDAO(this.em, TipoRelatorioDo.class);
	}

	public AnoDAO getAnoDAO() {
		return new AnoDAO(this.em, Ano.class);
	}
	
	public FocoDAO getFocoDAO() {
		return new FocoDAO(this.em, Foco.class);
	}

	public UnidadeAuditadaDAO getUnidadeAuditadaDAO() {
		return new UnidadeAuditadaDAO(this.em, UnidadeAuditada.class);
	}

	public NaturezaDAO getNaturezaDAO() {
		return new NaturezaDAO(this.em, Natureza.class);
	}

	public ColegiadoDAO getColegiadoDAO() {
		return new ColegiadoDAO(this.em, Colegiado.class);
	}

	public AreaTematicaDAO getAreaTematicaDAO() {
		return new AreaTematicaDAO(this.em, AreaTematica.class);
	}
	
	public UnidadeDAO getUnidadeDAO() {
		return new UnidadeDAO(this.em, Unidade.class);
	}

	public StatusRegistroDAO getStatusRegistroDAO() {
		return new StatusRegistroDAO(this.em, StatusRegistro.class);
	}	
	
}
