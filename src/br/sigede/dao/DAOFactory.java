package br.sigede.dao;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import br.sigede.model.DemandaAudin;
import br.sigede.model.DemandaDo;
import br.sigede.model.DemandaTcu;
import br.sigede.model.RegistroDemandaAudin;
import br.sigede.model.RegistroDemandaDo;
import br.sigede.model.RegistroDemandaTcu;
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

	public DemandaAudinDAO getDemandaAudinDAO() {
		return new DemandaAudinDAO(this.em, DemandaAudin.class);
	}
	
	public DemandaTcuDAO getDemandaTcuDAO() {
		return new DemandaTcuDAO(this.em, DemandaTcu.class);
	}
	
	public DemandaDoDAO getDemandaDoDAO() {
		return new DemandaDoDAO(this.em, DemandaDo.class);
	}
	
	public RegistroDemandaAudinDAO getRegistroDemandaAudinDAO() {
		return new RegistroDemandaAudinDAO(this.em, RegistroDemandaAudin.class);
	}
	
	public RegistroDemandaTcuDAO getRegistroDemandaTcuDAO() {
		return new RegistroDemandaTcuDAO(this.em, RegistroDemandaTcu.class);
	}
	
	public RegistroDemandaDoDAO getRegistroDemandaDoDAO() {
		return new RegistroDemandaDoDAO(this.em, RegistroDemandaDo.class);
	}
	
	
}
