package br.com.cna.exercicio3;

import java.util.LinkedList;

public class Threads3 {
	
	public static void executa(final int num) {
		//Collection Java que mantem a ordem de insercao em uma lista
		final LinkedList<Integer> lista = new LinkedList<>();
		new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < num; i++) 
					lista.add(i);
			}
		}.start();
		
		//imprime os valores processados
		new Thread() {

			@Override
			public void run() {
				for (int i = 0; i < lista.size(); i++) {
					System.out.println("Valor: " + lista.get(i));
				}
			}
		}.start();

	}
	
	public static void main(String[] args) {
		executa(100);
	}

}
