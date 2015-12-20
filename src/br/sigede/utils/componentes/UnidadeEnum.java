package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum UnidadeEnum {

	AUDIN("AUDIN"),
	BIOMANGUINHOS("Bio-Manguinhos"),
	CECAL("CECAL"),
	COC("COC"),
	CPQAM("CPqAM"),
	CPQGM("CPqGM"),
	CPQLMD("CPqLMD"),
	CPQRR("CPqRR"),
	CRIS("CRIS"),
	DIPLAN("DIPLAN"),
	DIREH("DIREH"),
	DIRAC("DIRAC"),
	TODAS("Todas as Unidades");
	
	private String unidade;
	
	UnidadeEnum(String unidade) {
		this.unidade = unidade;
	}
	
	public String getNome() {
		return unidade;
	}
	
	@Override
	public String toString() {
		return unidade;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (UnidadeEnum unidade : UnidadeEnum.values()) {			
			lista.add(unidade.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (UnidadeEnum unidade : UnidadeEnum.values()) {
			mapa.put(unidade.name(), unidade.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
	
}
