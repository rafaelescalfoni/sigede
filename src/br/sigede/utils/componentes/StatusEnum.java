package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum StatusEnum {
	
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String status;
	
	StatusEnum(String status) {
		this.status = status;
	}
	
	public String getNome() {
		return status;
	}
	
	@Override
	public String toString() {
		return status;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (StatusEnum status : StatusEnum.values()) {			
			lista.add(status.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (StatusEnum status : StatusEnum.values()) {
			mapa.put(status.name(), status.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
	
}
