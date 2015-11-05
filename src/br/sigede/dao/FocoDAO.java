package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.Foco;

public class FocoDAO extends DAOGenerico<Foco>{

	public FocoDAO(EntityManager em, Class<Foco> classe) {
		super(em, classe);
	}
	
}
