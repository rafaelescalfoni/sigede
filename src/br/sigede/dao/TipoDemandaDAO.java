package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.TipoDemanda;

public class TipoDemandaDAO extends DAOGenerico<TipoDemanda>{

	public TipoDemandaDAO(EntityManager em, Class<TipoDemanda> classe) {
		super(em, classe);
	}
	
}
