package br.sigede.dao;

import javax.persistence.EntityManager;

import br.sigede.model.TipoRelatorioDo;

public class TipoRelatorioDoDAO extends DAOGenerico<TipoRelatorioDo>{

	public TipoRelatorioDoDAO(EntityManager em, Class<TipoRelatorioDo> classe) {
		super(em, classe);
	}
	
}
