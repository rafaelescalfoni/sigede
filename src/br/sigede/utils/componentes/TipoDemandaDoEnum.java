package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum TipoDemandaDoEnum {

	EMAIL("E-Mail"),
	OFICIO("Ofício"),
	MEMORANDO("Memorando"),
	MEMORANDOCIRCULAR("Memorando-Circular"),
	TELEFONEMA("Telefonema");
	
	private String tipodemandado;
	
	TipoDemandaDoEnum(String tipodemandado) {
		this.tipodemandado = tipodemandado;
	}
	
	public String getNome() {
		return tipodemandado;
	}
	
	@Override
	public String toString() {
		return tipodemandado;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (TipoDemandaDoEnum tipodemandado : TipoDemandaDoEnum.values()) {			
			lista.add(tipodemandado.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (TipoDemandaDoEnum tipodemandado : TipoDemandaDoEnum.values()) {
			mapa.put(tipodemandado.name(), tipodemandado.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
	
}
