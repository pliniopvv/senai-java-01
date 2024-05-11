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
		
		
		Double median = array.stream().reduce((a,b) -> a+b).get()/array.size();
		System.out.println("Foram " + array.size() + " dias tendo consumido " + df.format(median) + " calorias/dia.");
	}

}
