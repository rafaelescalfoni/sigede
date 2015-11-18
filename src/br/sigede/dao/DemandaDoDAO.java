package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.DemandaDo;

public class DemandaDoDAO extends DAOGenerico<DemandaDo> {

	public DemandaDoDAO(EntityManager em, Class<DemandaDo> classe) {
		super(em, classe);
	}

}
