package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum NaturezaTcuEnum {

	ACORDAO("Acórdão"), 
	AUDIENCIA("Audiência"),
	COMUNICACAO("Comunicação"),
	DILIGÊNCIA("Diligência"),
	OITIVA("Oitiva");
	
	
	private String naturezatcu;
	
	NaturezaTcuEnum(String naturezatcu) {
		this.naturezatcu = naturezatcu;
	}
	
	public String getNome() {
		return naturezatcu;
	}
	
	@Override
	public String toString() {
		return naturezatcu;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (NaturezaTcuEnum naturezatcu : NaturezaTcuEnum.values()) {			
			lista.add(naturezatcu.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (NaturezaTcuEnum naturezatcu : NaturezaTcuEnum.values()) {
			mapa.put(naturezatcu.name(), naturezatcu.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}

}
