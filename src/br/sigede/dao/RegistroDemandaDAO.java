package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.RegistroDemanda;

public class RegistroDemandaDAO extends DAOGenerico<RegistroDemanda> {

	public RegistroDemandaDAO(EntityManager em, Class<RegistroDemanda> classe) {
		super(em, classe);
	}

}
