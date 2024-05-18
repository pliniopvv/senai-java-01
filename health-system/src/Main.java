import java.util.Scanner;

public class Main {

//	[M2S02] Ex. 04 - Sistema de Saúde - Telas do Console
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String cmdsList = "1 - Cadastrar um novo paciente;\r\n" + "2 - Listar todos os pacientes;\r\n"
				+ "4 - Alterar informações do paciente;\r\n" + "5 - Mostrar informações de um paciente;\r\n"
				+ "6 - Registrar atividade física para um paciente;\r\n" + "7 - Remover paciente.";
		System.out.println(cmdsList);

		System.out.print("\n\t >");
		int cmd = in.nextInt();

		switch (cmd) {
		default:
			System.out.println("Comando indefinido");
			break;
		}

		System.out.println("Aplicativo finalizado.");
	}

}
