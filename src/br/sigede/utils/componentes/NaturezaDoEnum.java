package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum NaturezaDoEnum {

	COMUNICACAO("Comunicação"),
	DILIGÊNCIA("Diligência"),
	RELATORIO("Relatório");
	
	
	private String naturezado;
	
	NaturezaDoEnum(String naturezado) {
		this.naturezado = naturezado;
	}
	
	public String getNome() {
		return naturezado;
	}
	
	@Override
	public String toString() {
		return naturezado;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (NaturezaDoEnum naturezado : NaturezaDoEnum.values()) {			
			lista.add(naturezado.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (NaturezaDoEnum naturezado : NaturezaDoEnum.values()) {
			mapa.put(naturezado.name(), naturezado.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}

}
