package calculo_area;

import java.util.Scanner;

public class CalculaArea {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite os par�metros da �rea � calcular:");
		System.out.print(" X = ");
		double x = in.nextDouble();
		System.out.print(" Y = ");
		double y = in.nextDouble();
		in.close();
		
		System.out.println("�rea total: \n\t\t" + x*y + " m�");
		
	}
}
