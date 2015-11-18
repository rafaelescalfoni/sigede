package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.DemandaTcu;

public class DemandaTcuDAO extends DAOGenerico<DemandaTcu> {

	public DemandaTcuDAO(EntityManager em, Class<DemandaTcu> classe) {
		super(em, classe);
	}

}
