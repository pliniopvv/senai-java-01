import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericBuilder<T extends Object> {

	public T build(Class<T> classe) throws InstantiationException, IllegalAccessException {
		Scanner in = new Scanner(System.in);

		System.out.println("### Obtendo " + classe.getName());
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

		return instance;
	}

}
