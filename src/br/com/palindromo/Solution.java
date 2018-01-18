package br.com.palindromo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
		
	static Set<Map<Character, Integer>> executa(String str) {
		Set<Map<Character, Integer>> lista = new HashSet<>();
		List<Character> lista2 = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = str.length() - 1; j >= 0 ; j--) {
				if(i == j) break;
				char c = str.charAt(i);
				char c2 = str.charAt(j);
				if(c == c2) {
					lista2.add(c);
				}			
			}
		}
		for (int i = 0; i < lista2.size(); i++) {
			char c = lista2.get(i);
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if(c == str.charAt(j)) 
					count++;
			}
			Map<Character, Integer> map = new HashMap<>();
			map.put(c, count);
			lista.add(map);	
			
		}
		return lista;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(executa(str));
	}

}
