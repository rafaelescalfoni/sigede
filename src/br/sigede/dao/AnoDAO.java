package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.Ano;

public class AnoDAO extends DAOGenerico<Ano>{

	public AnoDAO(EntityManager em, Class<Ano> classe) {
		super(em, classe);
	}
	
}
