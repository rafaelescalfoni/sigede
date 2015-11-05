package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.TipoRelatorioAudin;

public class TipoRelatorioAudinDAO extends DAOGenerico<TipoRelatorioAudin>{
	
	public TipoRelatorioAudinDAO(EntityManager em, Class<TipoRelatorioAudin> classe) {
		super(em, classe);
	}
	
}
