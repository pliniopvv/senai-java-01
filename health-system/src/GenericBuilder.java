import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//[M2S02] Ex. 05 - Sistema de Saúde - Cadastro Paciente
public class GenericBuilder<T extends Object> {

	public T build(Class<T> classe) throws InstantiationException, IllegalAccessException {
		Scanner in = Main.in;

		System.out.println("### Inserindo " + classe.getName());
		T instance = classe.newInstance();

		Field[] fields = classe.getDeclaredFields();
		for (Field field : fields) {
			if (Modifier.isStatic(field.getModifiers()))
				continue;

			Type tipo = field.getType();

			field.setAccessible(true);
			System.out.print(field.getName().replaceAll("_", " "));
//			System.out.print("#");
//			System.out.print(field.getType());

			if (tipo == List.class) {
				System.out.print("(Separe a lista por vírgulas)");
			}

			System.out.print("\t\t> ");
			String text = in.next();

			if (tipo == String.class)
				field.set(instance, text);
			else if (tipo == int.class)
				field.set(instance, Integer.parseInt(text));
			else if (tipo == double.class)
				field.set(instance, Double.parseDouble(text));
			else if (tipo == List.class) {
				String[] conteudo = text.split(",");
				ParameterizedType genericType = (ParameterizedType) field.getGenericType();
				Type gType = genericType.getActualTypeArguments()[0];
				ArrayList lista = new ArrayList();

				if (gType == String.class)
					for (String s : conteudo)
						lista.add(s);
				if (gType == int.class)
					for (String s : conteudo)
						lista.add(Integer.parseInt(s));
				if (gType == double.class)
					for (String s : conteudo)
						lista.add(Double.parseDouble(s));

				field.set(instance, lista);
			}

			field.setAccessible(false);
		}

//		in.close();
		return instance;
	}

//	[M2S02] Ex. 07 - Sistema de Saúde - Alterar Paciente
	public T alter(Class<T> classe, T model) throws IllegalArgumentException, IllegalAccessException {
		Scanner in = Main.in;
		
		System.out.println("### Alterando " + classe.getName());

		Field[] fields = classe.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Mutable.class)) {

				Type tipo = field.getType();

				field.setAccessible(true);
				System.out.print(field.getName().replaceAll("_", " "));
//				System.out.print("#");
//				System.out.print(field.getType());

				if (tipo == List.class) {
					System.out.print("(Separe a lista por vírgulas)");
				}

				System.out.print("\t\t> ");
				String text = in.next();

				if (tipo == String.class)
					field.set(model, text);
				else if (tipo == int.class)
					field.set(model, Integer.parseInt(text));
				else if (tipo == double.class)
					field.set(model, Double.parseDouble(text));
				else if (tipo == List.class) {
					String[] conteudo = text.split(",");
					ParameterizedType genericType = (ParameterizedType) field.getGenericType();
					Type gType = genericType.getActualTypeArguments()[0];
					ArrayList lista = new ArrayList();

					if (gType == String.class)
						for (String s : conteudo)
							lista.add(s);
					if (gType == int.class)
						for (String s : conteudo)
							lista.add(Integer.parseInt(s));
					if (gType == double.class)
						for (String s : conteudo)
							lista.add(Double.parseDouble(s));

					field.set(model, lista);
				}

				field.setAccessible(false);

			}
		}

//		in.close();
		return model;
	}

}
