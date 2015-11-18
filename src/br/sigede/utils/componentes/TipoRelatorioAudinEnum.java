package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum TipoRelatorioAudinEnum {

	CONFORMIDADE("Auditoria de Conformidade"), 
	CONFORMIDADERH("Auditoria de Conformidade em Recursos Humanos"),
	ESPECIAL("Auditoria Especial"),
	MONITORAMENTO("Monitoramento");
	
	
	private String tiporelatorioaudin;
	
	TipoRelatorioAudinEnum(String tiporelatorioaudin) {
		this.tiporelatorioaudin = tiporelatorioaudin;
	}
	
	public String getNome() {
		return tiporelatorioaudin;
	}
	
	@Override
	public String toString() {
		return tiporelatorioaudin;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (TipoRelatorioAudinEnum tiporelatorioaudin : TipoRelatorioAudinEnum.values()) {			
			lista.add(tiporelatorioaudin.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (TipoRelatorioAudinEnum tiporelatorioaudin : TipoRelatorioAudinEnum.values()) {
			mapa.put(tiporelatorioaudin.name(), tiporelatorioaudin.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
	
}
