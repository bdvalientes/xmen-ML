package co.com.xmen;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class XmenApplication {
	
	private static final Class<XmenApplication> SOURCE = XmenApplication.class;
	public static final String Version = "v1";

	public static void main(String[] args) {
		final SpringApplicationBuilder app = new SpringApplicationBuilder(XmenApplication.SOURCE);
		app.web(WebApplicationType.SERVLET);
		app.run(args);
	}

}
