package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.RegistroDemandaAudin;

public class RegistroDemandaAudinDAO extends DAOGenerico<RegistroDemandaAudin> {

	public RegistroDemandaAudinDAO(EntityManager em, Class<RegistroDemandaAudin> classe) {
		super(em, classe);
	}

}
