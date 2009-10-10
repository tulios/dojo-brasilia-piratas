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
		
		
		for(Integer pirata: mapa.keySet()){
			int indiceRubis = 0;
			while ((somatorio(mapa.get(pirata)) < quantoReceber) && (indiceRubis < listaDeTodosRubis.size())){
				if (somatorio(mapa.get(pirata))+listaDeTodosRubis.get(indiceRubis)
						<= quantoReceber) {
					mapa.get(pirata).add(listaDeTodosRubis.get(indiceRubis));
					listaDeTodosRubis.remove(indiceRubis);
				} else {
					indiceRubis++;
				}
			}
		}
		/*
		for(int x = 0 , y = 0; x < listaDeTodosRubis.size(); x++ , y++){
			int pirata = (y % qtdPirata) + 1;
			mapa.get(pirata).add(listaDeTodosRubis.get(x));
		}
		*/
		return mapa;
	}

	private int somatorio(List<Integer> lista){
		int somatorio = 0;
		for(Integer ruby: lista){
			somatorio += ruby;
		}
		return somatorio;
	}
	
	
}
