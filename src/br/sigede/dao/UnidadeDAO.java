package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.Unidade;

public class UnidadeDAO extends DAOGenerico<Unidade>{

	public UnidadeDAO(EntityManager em, Class<Unidade> classe) {
		super(em, classe);
	}
	
}
