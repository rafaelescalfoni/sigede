package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum ColegiadoEnum {
	
	PLENARIO("Plenário"),
	PRIMEIRACAMARA("Primeira Câmara"),
	SEGUNDACAMARA("Segunda Câmara");
	
	private String colegiado;
	
	ColegiadoEnum(String colegiado) {
		this.colegiado = colegiado;
	}
	
	public String getNome() {
		return colegiado;
	}
	
	@Override
	public String toString() {
		return colegiado;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (ColegiadoEnum colegiado : ColegiadoEnum.values()) {			
			lista.add(colegiado.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (ColegiadoEnum colegiado : ColegiadoEnum.values()) {
			mapa.put(colegiado.name(), colegiado.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
	
}
