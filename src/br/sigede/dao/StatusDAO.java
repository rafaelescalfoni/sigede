package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.Status;

public class StatusDAO extends DAOGenerico<Status>{
	
	public StatusDAO(EntityManager em, Class<Status> classe) {
		super(em, classe);
	}
}
