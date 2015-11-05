package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.StatusRegistro;

public class StatusRegistroDAO extends DAOGenerico<StatusRegistro>{

	public StatusRegistroDAO(EntityManager em, Class<StatusRegistro> classe) {
		super(em, classe);
	}
	
}
