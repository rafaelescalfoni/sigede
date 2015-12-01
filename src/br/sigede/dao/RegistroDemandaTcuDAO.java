package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.RegistroDemandaTcu;

public class RegistroDemandaTcuDAO extends DAOGenerico<RegistroDemandaTcu> {

	public RegistroDemandaTcuDAO(EntityManager em, Class<RegistroDemandaTcu> classe) {
		super(em, classe);
	}

}
