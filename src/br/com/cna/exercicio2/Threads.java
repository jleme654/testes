package br.com.cna.exercicio2;

import java.util.HashMap;
import java.util.Map;

public class Threads {

	public static Map<Integer, String> executa(final int num) {
		final Map<Integer, String> map = new HashMap<>();
		
		// thread producer - popula um map
		new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < num; i++) {
					map.put(i, "Nome da thread >>> registro: " + String.valueOf(i));
				}
			}
		}.start();
		
		// thread para printar os valores
		new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < map.size(); i++) {
					Object obj = map.get(i);
					System.out.println(obj.toString());
				}
			}
		}.start();
		
		// thread para remover as chaves
		new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < map.size(); i++) {
					Object obj = map.remove(i);
					System.out.println("removendo o registro >>> " + obj.toString());
				}
			}
		}.start();
		
		return map;
	}

	public static void main(String[] args) {
		executa(1000);
	}

}
