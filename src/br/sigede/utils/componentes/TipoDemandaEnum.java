package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum TipoDemandaEnum {

	DOU("Diário Oficial da União"),
	EMAIL("E-Mail"),
	OFICIO("Ofício"),
	TELEFONEMA("Telefonema");
	
	private String tipodemanda;
	
	TipoDemandaEnum(String tipodemanda) {
		this.tipodemanda = tipodemanda;
	}
	
	public String getNome() {
		return tipodemanda;
	}
	
	@Override
	public String toString() {
		return tipodemanda;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (TipoDemandaEnum tipodemanda : TipoDemandaEnum.values()) {			
			lista.add(tipodemanda.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (TipoDemandaEnum tipodemanda : TipoDemandaEnum.values()) {
			mapa.put(tipodemanda.name(), tipodemanda.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
}
