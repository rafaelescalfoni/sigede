package br.sigede.utils.componentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public enum AreaTematicaEnum {
	
	ADICTITULACAO("Adicional de Titulação"),
	ADICNOTURNO("Adicional Noturno"),
	ADMISSAO("Admissão de Pessoal"),
	ALMOXARIFADO("Almoxarifado"),
	APOSENTADORIA("Aposentadoria"),
	APOSPENSAO("Aposentadoria e Pensão"),
	AUXTRANSPORTE("Auxílio Transporte"),
	AVALRESULTADO("Avaliação de Resultados"),
	BEMIMOVEL("Bem Imóvel"),
	BEMMOVEL("Bem Móvel");
	
	private String areatematica;
	
	AreaTematicaEnum(String areatematica) {
		this.areatematica = areatematica;
	}
	
	public String getNome() {
		return areatematica;
	}
	
	@Override
	public String toString() {
		return areatematica;
	}
	
	public static final List<String> getList() {						
		List<String> lista = new ArrayList<String>();
		
		for (AreaTematicaEnum areatematica : AreaTematicaEnum.values()) {			
			lista.add(areatematica.getNome());
		}	

		return lista;
	}
	
	public static final Map<String, String> getMap() {
		Map<String, String> mapa = new HashMap<String, String>();
		
		for (AreaTematicaEnum areatematica : AreaTematicaEnum.values()) {
			mapa.put(areatematica.name(), areatematica.getNome());
					
		}
		
		return new TreeMap<String, String>(mapa);
	}
	
}
