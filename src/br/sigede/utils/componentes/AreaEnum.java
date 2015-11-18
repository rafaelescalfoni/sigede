package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum AreaEnum {

	CGTI("Coordenação de Gestão de Tecnologia da Informação - CGTI"),
	AGI("Área de Acompanhamento e Gestão da Informação - AGI"),
	AAA("Área de Ações de Auditoria - AAA"),
	ARH("Área de Ações de Auditoria em Recursos Humanos - ARH"),
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
