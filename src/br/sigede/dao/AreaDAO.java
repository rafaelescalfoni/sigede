package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.Area;

public class AreaDAO extends DAOGenerico<Area>{

	public AreaDAO(EntityManager em, Class<Area> classe) {
		super(em, classe);
	}
	
}
