
public class Main {

	public static void main(String[] args) {
		Paciente a = new Paciente();
		Paciente b = new Paciente();
		Paciente c = new Paciente();
		
		a.setNome("Paciente A");
		b.setNome("Paciente B");
		c.setNome("Paciente C");

		System.out.println(a.listar());

		for (Paciente p : a.listar()) {
			System.out.println(p.getNome());
		}
	}

}
