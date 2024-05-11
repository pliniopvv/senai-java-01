package monitor_calorias;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MonitorCalorias {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##");
		
		System.out.println("Entre com os valores das calorias (0 -> finalizar): \n");
		
		ArrayList<Double> array = new ArrayList<>();
		
		while (true) {
			System.out.print(" \t\t >  ");
			double cal = in.nextDouble();
			if (cal == 0) break;
			array.add(cal);
		}
		in.close();
		
		System.out.println("\n\n Analizando os dados :");
		
		System.out.println("\t Foi consumido mais que o recomendado (2000 cal) nos dias (a partir do primeiro) :");
		
		for (int i =0;i<array.size();i++)
			if (array.get(i) > 2000.00) { System.out.println("\t\t" + (i+1)); }
		
		
		Double median = array.stream().reduce((a,b) -> a+b).get()/array.size();
		System.out.println("Foram " + array.size() + " dias consumindo " + df.format(median) + " calorias/dia.");
	}

}
