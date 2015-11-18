package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.Demanda;

public class DemandaDAO extends DAOGenerico<Demanda> {

	public DemandaDAO(EntityManager em, Class<Demanda> classe) {
		super(em, classe);
	}

}
