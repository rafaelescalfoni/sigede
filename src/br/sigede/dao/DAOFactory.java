package br.sigede.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.sigede.model.Area;
import br.sigede.model.Status;
import br.sigede.model.TipoDemanda;
import br.sigede.model.TipoRelatorioAudin;
import br.sigede.model.TipoRelatorioDo;
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
	
}
