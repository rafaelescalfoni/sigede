package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum TipoDemandaAudinEnum {

	RELATORIO("Relatório");
	
	private String tipodemandaaudin;
	
	TipoDemandaAudinEnum(String tipodemandaaudin) {
		this.tipodemandaaudin = tipodemandaaudin;
	}
	
	public String getNome() {
		return tipodemandaaudin;
	}
	
	@Override
	public String toString() {
		return tipodemandaaudin;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (TipoDemandaAudinEnum tipodemandaaudin : TipoDemandaAudinEnum.values()) {			
			lista.add(tipodemandaaudin.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (TipoDemandaAudinEnum tipodemandaaudin : TipoDemandaAudinEnum.values()) {
			mapa.put(tipodemandaaudin.name(), tipodemandaaudin.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
}
