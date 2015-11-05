package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.UnidadeAuditada;

public class UnidadeAuditadaDAO extends DAOGenerico<UnidadeAuditada>{

	public UnidadeAuditadaDAO(EntityManager em, Class<UnidadeAuditada> classe) {
		super(em, classe);
	}
	
}
