import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Paciente a = new Paciente();

		a.setNome("Paciente A");
		a.setAltura(20.2);

		List<String> atividades = new ArrayList<String>();
		atividades.add("HIIT");
		atividades.add("Corrida");

		a.setAtividadesFisicas(atividades);
		a.setDieta_alimentar("Sem glúten");
		a.setIdade(24);
		a.setNome("Thomas Thurbano");
		a.setPeso(84);
		a.setPressao_arterial(12);

		for (Paciente p : a.listar()) {
			p.monitorar();
		}
	}

}
