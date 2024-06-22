package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Consumer;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.PetShopResponse;

public abstract class ServletTools {

	public static void send(HttpServletResponse resp, String msg) throws IOException {
		resp.getWriter().append("<html><p>" + msg + "</p></html>");
	}

	public static void send(HttpServletResponse resp, List<? extends PetShopResponse> list) throws IOException {
		final StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<p>");

		for (int i = 0; i < list.size(); i++) {
			PetShopResponse x = list.get(i);
			sb.append("<p>" + i + " - " + x.toString() + "</p>");
		}

		list.forEach(new Consumer<PetShopResponse>() {
			@Override
			public void accept(PetShopResponse pet) {

			}
		});
		sb.append("</p>");
		sb.append("</html>");
		resp.getWriter().append(sb.toString());
	}

	public static <T> T jsonTo(Class<T> classs, HttpServletRequest req) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String line = "";
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		System.out.println(sb.toString());

		Gson gson = new Gson();
		return gson.fromJson(sb.toString(), classs);
	}
}
