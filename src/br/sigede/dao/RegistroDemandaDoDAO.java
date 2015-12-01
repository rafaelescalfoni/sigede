package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.RegistroDemandaDo;

public class RegistroDemandaDoDAO extends DAOGenerico<RegistroDemandaDo> {

	public RegistroDemandaDoDAO(EntityManager em, Class<RegistroDemandaDo> classe) {
		super(em, classe);
	}

}
