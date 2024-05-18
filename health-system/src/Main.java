import java.util.Scanner;

public class Main {
	
	public static Scanner in;

//	[M2S02] Ex. 04 - Sistema de Saúde - Telas do Console
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		in = new Scanner(System.in);
		
		GenericBuilder<Paciente> gb;
		Paciente paciente;

		String cmdsList = "1 - Cadastrar um novo paciente;\r\n" + "2 - Listar todos os pacientes;\r\n"
				+ "4 - Alterar informações do paciente;\r\n" + "5 - Mostrar informações de um paciente;\r\n"
				+ "6 - Registrar atividade física para um paciente;\r\n" + "7 - Remover paciente.\r\n" + "0 - Sair;";
		System.out.println(cmdsList);

		while (true) {
//			in = new Scanner(System.in);
			System.out.print("\t > ");
			int cmd = in.nextInt();
			

			switch (cmd) {
//			[M2S02] Ex. 05 - Sistema de Saúde - Cadastro Paciente
			case 1:
				gb = new GenericBuilder<>();
				paciente = gb.build(Paciente.class);
				System.out.println("\n\nPaciente adicionado");
//				Paciente.addPaciente(p);
				break;
//			[M2S02] Ex. 06 - Sistema de Saúde - Listar Paciente
			case 2:
				Paciente[] lista = Paciente.getList();
				for (int i = 0; i < lista.length; i++)
					System.out.println(i + " - " + lista[i].getNome());
				break;
//			[M2S02] Ex. 07 - Sistema de Saúde  - Alterar Paciente
			case 4:
				gb = new GenericBuilder<>();
				System.out.print("id > ");
				int idx = in.nextInt();
				paciente = gb.alter(Paciente.class, Paciente.getList()[idx]);
				break;
			case 0:
				break;
			default:
				System.out.println("Comando indefinido");
				break;
			}
			if (cmd == 0)
				break;
			System.out.println("Último Comando finalizado.");
		}

		in.close();
		System.out.println("Aplicativo finalizado.");
	}

}
