package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.DemandaAudin;

public class DemandaAudinDAO extends DAOGenerico<DemandaAudin> {

	public DemandaAudinDAO(EntityManager em, Class<DemandaAudin> classe) {
		super(em, classe);
	}

}
