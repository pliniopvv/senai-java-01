import java.util.Scanner;

public class Main {

//	[M2S02] Ex. 04 - Sistema de Saúde - Telas do Console
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Scanner in = new Scanner(System.in);

		String cmdsList = "1 - Cadastrar um novo paciente;\r\n" + "2 - Listar todos os pacientes;\r\n"
				+ "4 - Alterar informações do paciente;\r\n" + "5 - Mostrar informações de um paciente;\r\n"
				+ "6 - Registrar atividade física para um paciente;\r\n" + "7 - Remover paciente.";
		System.out.println(cmdsList);

		System.out.print("\n\t >");
		int cmd = in.nextInt();

		switch (cmd) {
//		[M2S02] Ex. 05 - Sistema de Saúde - Cadastro Paciente
		case 1:
			GenericBuilder<Paciente> gb = new GenericBuilder<>();
			Paciente p = gb.build(Paciente.class);
			System.out.println("\n\nPaciente adicionado");
			Paciente.addPaciente(p);
			break;
		default:
			System.out.println("Comando indefinido");
			break;
		}

		System.out.println("Aplicativo finalizado.");
	}

}
