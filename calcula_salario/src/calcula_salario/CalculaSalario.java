package calcula_salario;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CalculaSalario {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o sal�rio bruto (utilize v�rgula para os centavos):");
		System.out.print(" R$ ");
		double soldo = in.nextDouble();
		double UmSoldo = 1412.00;
		in.close();
		
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("Voc� recebe um total de: \n\t\t" + df.format(soldo/UmSoldo) + " sal�rios m�nimos");
	}
}
