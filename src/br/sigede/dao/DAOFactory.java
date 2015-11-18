package br.sigede.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.sigede.model.Demanda;
import br.sigede.model.DemandaAudin;
import br.sigede.model.DemandaDo;
import br.sigede.model.DemandaTcu;
import br.sigede.model.RegistroDemanda;
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

	public DemandaDAO getDemandaDAO() {
		return new DemandaDAO(this.em, Demanda.class);
	}
	
	public DemandaAudinDAO getDemandaAudinDAO() {
		return new DemandaAudinDAO(this.em, DemandaAudin.class);
	}
	
	public DemandaTcuDAO getDemandaTcuDAO() {
		return new DemandaTcuDAO(this.em, DemandaTcu.class);
	}
	
	public DemandaDoDAO getDemandaDoDAO() {
		return new DemandaDoDAO(this.em, DemandaDo.class);
	}
	
	public RegistroDemandaDAO getRegistroDemandaDAO() {
		return new RegistroDemandaDAO(this.em, RegistroDemanda.class);
	}
}
