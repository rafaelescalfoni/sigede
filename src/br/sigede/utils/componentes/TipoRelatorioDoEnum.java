package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum TipoRelatorioDoEnum {

	AAC("Auditoria Anual de Contas"), 
	AE("Auditoria Especial"),
	APG("Acompanhamento Permanente dos Gastos"),
	DEMANDASESPECIAIS("Demandas Especiais"),
	DEMANDASEXTERNAS("Demandas Externas");
	
	
	private String tiporelatoriodo;
	
	TipoRelatorioDoEnum(String tiporelatoriodo) {
		this.tiporelatoriodo = tiporelatoriodo;
	}
	
	public String getNome() {
		return tiporelatoriodo;
	}
	
	@Override
	public String toString() {
		return tiporelatoriodo;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (TipoRelatorioDoEnum tiporelatoriodo : TipoRelatorioDoEnum.values()) {			
			lista.add(tiporelatoriodo.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (TipoRelatorioDoEnum tiporelatoriodo : TipoRelatorioDoEnum.values()) {
			mapa.put(tiporelatoriodo.name(), tiporelatoriodo.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
	
}
