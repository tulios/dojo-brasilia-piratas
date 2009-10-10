package br.dojobrasilia.pirata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loot{
	
	String[] argumentos;
	public Integer qtdPirata = null;
	public List<Integer> listaDeTodosRubis = null;
	
	public Loot(String[] args){
		argumentos = args;
		try {
			qtdPirata= Integer.parseInt(args[0]);
			listaDeTodosRubis = new ArrayList<Integer>();
			for (String rubi : args) {
				listaDeTodosRubis.add(Integer.parseInt(rubi));
			}
			listaDeTodosRubis.remove(0);
		}catch (Exception e) {
			
		}
	}
	
	public Map<Integer, List<Integer>> partilhaRubis() {
		
		if (qtdPirata > listaDeTodosRubis.size()) {
			return null;
		}
		
		Collections.sort(listaDeTodosRubis);
		Collections.reverse(listaDeTodosRubis);
		
		Map<Integer, List<Integer>> mapa = new HashMap<Integer, List<Integer>>();

		int somatorio = 0;
		for(Integer ruby: listaDeTodosRubis){
			somatorio += ruby;
		}
		
		int quantoReceber = somatorio / qtdPirata;
		
		for(int x = 0; x < qtdPirata; x++){
			mapa.put(x+1, new ArrayList<Integer>());
		}
		
		List<Integer> rubisExcluidos = new ArrayList<Integer>();
		for(Integer pirata: mapa.keySet()){

			distribuirRubis(listaDeTodosRubis, mapa.get(pirata), quantoReceber);
			
			if (somatorio(mapa.get(pirata)) != quantoReceber){
				while (somatorio(mapa.get(pirata)) != quantoReceber) {
					int ultimoIndice = mapa.get(pirata).size() - 1;
					
					rubisExcluidos.add(mapa.get(pirata).remove(ultimoIndice));
					distribuirRubis(listaDeTodosRubis, mapa.get(pirata), quantoReceber);
						
				}
				listaDeTodosRubis.addAll(rubisExcluidos);
				rubisExcluidos.clear();
			}
		}
		
		return mapa;
	}

	private void distribuirRubis(List<Integer> listaDeTodosRubis, List<Integer> listaRubisPirata, int quantoReceber){
		int indiceRubis = 0;
		while ((somatorio(listaRubisPirata) < quantoReceber) && (indiceRubis < listaDeTodosRubis.size())){
			int quantoTemMaisProximoRuby = somatorio(listaRubisPirata)+listaDeTodosRubis.get(indiceRubis);
			
			if (quantoTemMaisProximoRuby <= quantoReceber) {
				
				listaRubisPirata.add(listaDeTodosRubis.remove(indiceRubis));
				
			} else {
				indiceRubis++;
			}
		}
	}
	
	private int somatorio(List<Integer> lista){
		int somatorio = 0;
		for(Integer ruby: lista){
			somatorio += ruby;
		}
		return somatorio;
	}
	
	
}
