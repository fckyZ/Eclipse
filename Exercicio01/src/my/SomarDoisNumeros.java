package my;

import java.util.Scanner;

class SomarDoisNumeros {
	public static Scanner sc = new Scanner ( System.in );
	
	public static void main ( String [ ] Args )
	{
		int num01 = 0, num02 = 0, soma = 0;
		
		System.out.println ( "Digite O Valor Do Primeiro Numero :" );
		num01 = sc.nextInt ( );
	
		
		System.out.println ( "Digite O Valor Do Segundo Numero :" );
		num02 = sc.nextInt ( );
		
		soma = num01 + num02;
		
		System.out.println ( "Soma = " + soma );
	}
}