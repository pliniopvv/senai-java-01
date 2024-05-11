package calcula_velocidade;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculaVelocidade {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Qual o tempo at� a pr�xima placa?");
		System.out.print(" \n\t\t >  ");
		double time = in.nextDouble();
		double distance = 1.00;
		in.close();
		
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("A velocidade m�dia �: \n\t\t" + df.format(distance/time) + " segundos/metro");
	}

}
