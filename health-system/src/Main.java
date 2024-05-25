import java.text.SimpleDateFormat;
import java.util.Scanner;

import entidades.Consulta;
import entidades.Endereco;
import entidades.Funcionario;
import entidades.Nutricionista;
import entidades.Paciente;
import repositorio.GenericBuilder;

public class Main {

	public static Scanner in;

//	[M2S02] Ex. 04 - Sistema de Sa�de - Telas do Console
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		in = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		GenericBuilder<Paciente> gbPaciente;
		GenericBuilder<Funcionario> gbFuncionario;
		GenericBuilder<Nutricionista> gbNutricionista;
		GenericBuilder<Consulta> gbConsulta;
		GenericBuilder<Endereco> gbEndereco;
		Paciente paciente;
		int idx;

		String cmdsList = "1 - Cadastrar um novo paciente;\r\n" + "2 - Listar todos os pacientes;\r\n"
				+ "3 - Alterar informa��es do paciente;\r\n" + "4 - Mostrar informa��es de um paciente;\r\n"
				+ "5 - Registrar atividade f�sica para um paciente;\r\n" + "6 - Remover paciente.\r\n"
				+ "7 - Cadastrar Funcion�rio.\r\n" + "8 - Cadastrar Nutricionista.\r\n" + "9 - Cadastrar Consulta.\r\n"
				+ "10 - Listar Funcionario.\r\n" + "11 - Listar Nutricionista.\r\n" + "12 - Listar Consulta.\r\n"
				+ "13 - Realizar Consulta.\r\n" + "0 - Sair;";
		System.out.println(cmdsList);

		while (true) {
//			in = new Scanner(System.in);
			System.out.print("\t > ");
			int cmd = in.nextInt();

			switch (cmd) {
//			[M2S02] Ex. 05 - Sistema de Sa�de - Cadastro Paciente
			case 1:
				gbPaciente = new GenericBuilder<>(in);
				paciente = gbPaciente.build(Paciente.class);
				System.out.println("\n\nPaciente adicionado");
//				Paciente.addPaciente(p);
				break;
//			[M2S02] Ex. 06 - Sistema de Sa�de - Listar Paciente
			case 2: {
				Paciente[] lista = Paciente.getList();
				for (int i = 0; i < lista.length; i++)
					System.out.println(i + " - " + lista[i].getNome());
				System.out.println("Fim da lista.");
			}
				break;
//			[M2S02] Ex. 07 - Sistema de Sa�de  - Alterar Paciente
			case 3:
				gbPaciente = new GenericBuilder<>(in);
				System.out.print("id > ");
				idx = in.nextInt();
				paciente = gbPaciente.alter(Paciente.class, Paciente.getList()[idx]);
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
//			[M2S02] Ex. 10 - Sistema de Sa�de - Remover paciente
			case 6:
				System.out.print("id > ");
				idx = in.nextInt();
				Paciente.remove(idx);
				break;
//			[M2S03] Ex. 09 - Sistema de Sa�de Parte 2 - Telas Novas
			case 7: // Telas novas | Build Funcion�rio
				gbFuncionario = new GenericBuilder<>(in);
				Funcionario f = gbFuncionario.build(Funcionario.class);
				gbEndereco = new GenericBuilder<>(in);
				Endereco end = gbEndereco.build(Endereco.class);
				f.setEndereco(end);
				break;
			case 8: { // Telas novas | Build Nutricionista
				gbNutricionista = new GenericBuilder<>(in);
				Nutricionista n = gbNutricionista.build(Nutricionista.class);
			}
				break;
			case 9: { // Telas novas | Build Consulta
				boolean confirm = false;
				gbConsulta = new GenericBuilder<>(in);
				Consulta c = gbConsulta.build(Consulta.class);
				while (!confirm) {
					boolean localized = false;
					for (Paciente p : Paciente.getList())
						if (p.getNome().equals(c.getNome_paciente()))
							localized = true;
					if (localized) {
						confirm = true;
					} else {
						System.out.println("Nome de paciente n�o localizado, tente novamente.\n\t\t>");
						String novoNome = in.next();
						c.setNome_paciente(novoNome);
					}
				}
				confirm = false;
				while (!confirm) {
					boolean localized = false;
					for (Nutricionista n : Nutricionista.getList())
						if (n.getNome().equals(c.getNome_paciente()))
							localized = true;
					if (localized) {
						confirm = true;
					} else {
						System.out.println("Nome de nutricionista n�o localizado, tente novamente.\n\t\t>");
						String novoNome = in.next();
						c.setNome_paciente(novoNome);
					}
				}
			}
				break;
			case 10: { // Telas novas | Listar Funcionarios
				Funcionario[] lista = Funcionario.getList();
				for (int i = 0; i < lista.length; i++)
					System.out.println(i + " - " + lista[i].getNome());
				System.out.println("Fim da lista.");
			}
				break;
			case 11: { // Telas novas | Listar Nutricionista
				Nutricionista[] lista = Nutricionista.getList();
				for (int i = 0; i < lista.length; i++)
					System.out.println(i + " - " + lista[i].getNome());
				System.out.println("Fim da lista.");
			}
				break;
			case 12: { // Telas novas | Listar Consulta
				Consulta[] lista = Consulta.getList();
				System.out.println("Data \t - \t Nutricionista \t - \t Paciente \t - \t Realizada?");
				for (int i = 0; i < lista.length; i++)
					System.out.println(sdf.format(lista[i].getData()) + "\t - \t" + lista[i].getNome_nutricionista()
							+ "\t - \t" + lista[i].getNome_paciente() + "\t - \t"
							+ (lista[i].isRealizada() ? "Realizada (Sim)" : "N�o realizada (N�o)"));
				System.out.println("Fim da lista.");
			}
			case 13: { // Telas novas | Realizar Consulta
				System.out.print("id > ");
				idx = in.nextInt();
				Consulta.getList()[idx].setRealizada(!Consulta.getList()[idx].isRealizada());
			}
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
