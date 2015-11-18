package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum AnoEnum {

	ANO2015("2015"),
	ANO2014("2014"),
	ANO2013("2013");
	
private String ano;
	
	AnoEnum(String ano) {
		this.ano = ano;
	}
	
	public String getNome() {
		return ano;
	}
	
	@Override
	public String toString() {
		return ano;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (AnoEnum ano : AnoEnum.values()) {			
			lista.add(ano.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (AnoEnum ano : AnoEnum.values()) {
			mapa.put(ano.name(), ano.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
	
}
