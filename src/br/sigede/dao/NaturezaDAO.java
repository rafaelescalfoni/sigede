package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.Natureza;

public class NaturezaDAO extends DAOGenerico<Natureza>{

	public NaturezaDAO(EntityManager em, Class<Natureza> classe) {
		super(em, classe);
	}
	
}
