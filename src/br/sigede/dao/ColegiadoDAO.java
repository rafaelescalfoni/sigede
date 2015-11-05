package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.Colegiado;

public class ColegiadoDAO extends DAOGenerico<Colegiado>{

	public ColegiadoDAO(EntityManager em, Class<Colegiado> classe) {
		super(em, classe);
	}
	
}
