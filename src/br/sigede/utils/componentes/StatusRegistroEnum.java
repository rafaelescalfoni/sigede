package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum StatusRegistroEnum {

	ATENDIDO("Atendido"), 
	ATENDIDOPARCIALMENTE("Atendido Parcialmente"),
	NAOATENDIDO("Não Atendido"),
	MONITORADO("Será Monitorado pela Auditoria Interna");
	
	
	private String statusregistro;
	
	StatusRegistroEnum(String statusregistro) {
		this.statusregistro = statusregistro;
	}
	
	public String getNome() {
		return statusregistro;
	}
	
	@Override
	public String toString() {
		return statusregistro;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (StatusRegistroEnum statusregistro : StatusRegistroEnum.values()) {			
			lista.add(statusregistro.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (StatusRegistroEnum statusregistro : StatusRegistroEnum.values()) {
			mapa.put(statusregistro.name(), statusregistro.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}

}
