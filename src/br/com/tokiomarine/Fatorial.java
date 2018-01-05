package br.com.tokiomarine;

public class Fatorial {

	public static void main(String[] args) {
		int x = 5, f=x;
		while (x > 1){  
            f = f *(x-1); 
            x--; 
            //System.out.print(f + " ");
		}
		//System.out.println();
		System.out.println(f);
	}

}
