import java.util.Scanner;

public class Main {

	public static Scanner in;

//	[M2S02] Ex. 04 - Sistema de Sa�de - Telas do Console
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		in = new Scanner(System.in);

		GenericBuilder<Paciente> gb;
		Paciente paciente;
		int idx;

		String cmdsList = "1 - Cadastrar um novo paciente;\r\n" + "2 - Listar todos os pacientes;\r\n"
				+ "3 - Alterar informa��es do paciente;\r\n" + "4 - Mostrar informa��es de um paciente;\r\n"
				+ "5 - Registrar atividade f�sica para um paciente;\r\n" + "6 - Remover paciente.\r\n" + "0 - Sair;";
		System.out.println(cmdsList);

		while (true) {
//			in = new Scanner(System.in);
			System.out.print("\t > ");
			int cmd = in.nextInt();

			switch (cmd) {
//			[M2S02] Ex. 05 - Sistema de Sa�de - Cadastro Paciente
			case 1:
				gb = new GenericBuilder<>();
				paciente = gb.build(Paciente.class);
				System.out.println("\n\nPaciente adicionado");
//				Paciente.addPaciente(p);
				break;
//			[M2S02] Ex. 06 - Sistema de Sa�de - Listar Paciente
			case 2:
				Paciente[] lista = Paciente.getList();
				for (int i = 0; i < lista.length; i++)
					System.out.println(i + " - " + lista[i].getNome());
				break;
//			[M2S02] Ex. 07 - Sistema de Sa�de  - Alterar Paciente
			case 3:
				gb = new GenericBuilder<>();
				System.out.print("id > ");
				idx = in.nextInt();
				paciente = gb.alter(Paciente.class, Paciente.getList()[idx]);
				break;
//			[M2S02] Ex. 08 - Sistema de Sa�de - Exibir informa��es do Paciente
			case 4:
				System.out.print("id > ");
				idx = in.nextInt();
				Paciente.getList()[idx].monitorar();
				break;
//			[M2S02] Ex. 09 - Sistema de Sa�de - Atividade f�sica
			case 5:
				System.out.print("id > ");
				idx = in.nextInt();
				String atividade = in.next();
				Paciente.getList()[idx].registrarAtividade(atividade);
				break;
			case 0:
				break;
			default:
				System.out.println("Comando indefinido");
				break;
			}
			if (cmd == 0)
				break;
			System.out.println("�ltimo Comando finalizado.");
		}

		in.close();
		System.out.println("Aplicativo finalizado.");
	}

}
