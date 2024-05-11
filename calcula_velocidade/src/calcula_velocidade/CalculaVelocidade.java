package calcula_velocidade;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculaVelocidade {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Qual o tempo até a próxima placa?");
		System.out.print(" \n\t\t >  ");
		double time = in.nextDouble();
		double distance = 1.00;
		in.close();
		
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("A velocidade média é: \n\t\t" + df.format(distance/time) + " segundos/metro");
	}

}
