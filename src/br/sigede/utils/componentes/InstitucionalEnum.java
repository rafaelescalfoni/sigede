package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum InstitucionalEnum {
	
	SIM("Sim"),
	NAO("Não");
	
	private String institucional;
	
	InstitucionalEnum(String institucional) {
		this.institucional = institucional;
	}
	
	public String getNome() {
		return institucional;
	}
	
	@Override
	public String toString() {
		return institucional;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (InstitucionalEnum institucional : InstitucionalEnum.values()) {			
			lista.add(institucional.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (InstitucionalEnum institucional : InstitucionalEnum.values()) {
			mapa.put(institucional.name(), institucional.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
	
}
