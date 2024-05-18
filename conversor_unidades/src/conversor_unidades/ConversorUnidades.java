package conversor_unidades;

import java.util.Scanner;

public class ConversorUnidades {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		while (true) {
			D.showInitialMenu();
			int o = in.nextInt();
			if (o == 0)
				break;

			int o1, o2;
			double medida;

			switch (o) {
			case 1: // comprimento
				D.showComprimentoMenu();
				D.msg("Origem > ");
				o1 = in.nextInt();
				D.msg("Destino > ");
				o2 = in.nextInt();
				D.msg("Valor > ");
				medida = in.nextDouble();
				D.result(C.Comprimento(o1, o2, medida));
				D.resultComprimento(o1, o2);
				break;
			case 2: // peso
				D.showPesoMenu();
				D.msg("Origem > ");
				o1 = in.nextInt();
				D.msg("Destino > ");
				o2 = in.nextInt();
				D.msg("Valor > ");
				medida = in.nextDouble();
				D.result(C.Peso(o1, o2, medida));
				D.resultPeso(o1, o2);
				break;
			default:
				D.msg("Comando indefinido.");
				break;
			}
			D.msgln("\n ----------------------------------------- ");
		}

		in.close();
		D.msgln("Aplicativo finalizado.");
	}

	public abstract static class D {
		static void showInitialMenu() {
			System.out.print("Escolha a categoria: \n\t\t1. Comprimento\n\t\t2. Peso\n\t\t0. Sair\n\t\t > ");
		}

		static void showComprimentoMenu() {
			System.out
					.println("Escolha a unidade: \n\t\t1. Metros (m)\n\t\t2. Centímetros (cm)\n\t\t3. Polegadas (in)");
		}

		static void showPesoMenu() {
			System.out.println("Escolha a unidade: \n\t\t1. Quilogramas (kg)\n\t\t2. Gramas (g)\n\t\t3. Libras (lb)");
		}

		private static String optionPesoToString(int option) {
			switch (option) {
			case 1:
				return " Quilograma (Kg) ";
			case 2:
				return " Grama (g) ";
			case 3:
				return " Libra (lb) ";
			default:
				return "Indefinido";
			}
		}

		private static String optionComprimentoToString(int option) {
			switch (option) {
			case 1:
				return " Metros (m) ";
			case 2:
				return " Centímetros (cm) ";
			case 3:
				return " Polegadas (in) ";
			default:
				return "Indefinido";
			}
		}

		static void result(double resultado) {
			System.out.println("O Resultado da conversão foi: " + resultado);
		}

		static void resultPeso(int o1, int o2) {
			D.msg(D.optionPesoToString(o1));
			D.msg(" -> ");
			D.msg(D.optionPesoToString(o2));
		}

		static void resultComprimento(int o1, int o2) {
			D.msg(D.optionComprimentoToString(o1));
			D.msg(" -> ");
			D.msg(D.optionComprimentoToString(o2));
		}

		static void msg(String msg) {
			System.out.print(msg);
		}

		static void msgln(String msg) {
			System.out.println(msg);
		}
	}

	public abstract static class C {
		static double Comprimento(int oOrigem, int oDestino, double medida) {
			int unified = oOrigem * 10 + oDestino;
			double fator = 1.0;
			switch (unified) {
			case 12:
				fator = 0.01;
				break;
			case 13:
				fator = 0.0254;
				break;
			case 21:
				fator = 100;
				break;
			case 23:
				fator = 2.54;
				break;
			case 31:
				fator = 254;
				break;
			case 32:
				fator = 0.3937007874015748;
				break;
			}
			return fator * medida;
		}

		static double Peso(int oOrigem, int oDestino, double medida) {
			int unified = oOrigem * 10 + oDestino;
			double fator = 1.0;
			switch (unified) {
			case 12:
				fator = 1000;
				break;
			case 13:
				fator = 2.20462262;
				break;
			case 21:
				fator = 0.001;
				break;
			case 23:
				fator = 0.00220462262;
				break;
			case 31:
				fator = 0.45359237;
				break;
			case 32:
				fator = 0.00045359237;
				break;
			}
			return fator * medida;
		}

	}
}
