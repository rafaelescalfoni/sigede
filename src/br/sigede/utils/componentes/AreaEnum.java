package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum AreaEnum {

	CGTI("Coordena��o de Gest�o de Tecnologia da Informa��o - CGTI"),
	AGI("�rea de Acompanhamento e Gest�o da Informa��o - AGI"),
	AAA("�rea de A��es de Auditoria - AAA"),
	ARH("�rea de A��es de Auditoria em Recursos Humanos - ARH"),
	CHEFIA("Chefia"),
	SECRETARIA("Secretaria");
	
	private String area;
	
	AreaEnum(String area) {
		this.area = area;
	}
	
	public String getNome() {
		return area;
	}
	
	@Override
	public String toString() {
		return area;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (AreaEnum area : AreaEnum.values()) {			
			lista.add(area.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (AreaEnum area : AreaEnum.values()) {
			mapa.put(area.name(), area.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
	
}
