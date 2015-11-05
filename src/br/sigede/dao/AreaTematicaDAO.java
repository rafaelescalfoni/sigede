package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.AreaTematica;

public class AreaTematicaDAO extends DAOGenerico<AreaTematica>{

	public AreaTematicaDAO(EntityManager em, Class<AreaTematica> classe) {
		super(em, classe);
	}
	
}
