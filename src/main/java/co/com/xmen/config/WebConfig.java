package co.com.xmen.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.zalando.logbook.HttpLogFormatter;
import org.zalando.logbook.Sink;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor()
public class WebConfig implements WebMvcConfigurer {

	@Bean
	public GroupedOpenApi depositoApi() {
		return GroupedOpenApi.builder().group("API REST ML").packagesToScan("co.com.xmen.controller").build();

	}

	@Bean
	public OpenAPI metaData() {
		return new OpenAPI()
				.info(new Info().title("API REST X-MEN").description("Validacion cadena ADN").version("1.0.0"));
	}

	@Bean
	public Sink sink(HttpLogFormatter httpLogFormatter) {
		return new SinkDatabase(httpLogFormatter);
	}

}
