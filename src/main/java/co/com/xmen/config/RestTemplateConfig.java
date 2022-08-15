package co.com.xmen.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configurable
public class RestTemplateConfig {

	@Value("${ws.client.api.connect.timeout}")
	private static int timeOutAPI;

	@Value("${ws.client.api.read.timeout}")
	private static int readTimeOutAPI;

	@Value("${ws.client.osb.connect.timeout}")
	private static int timeOutOBS;

	@Value("${ws.client.osb.read.timeout}")
	private static int readTimeOutOBS;

	private static RestTemplate miRestTemplateConfigAPI = null;

	public static RestTemplate getConfiguradorAPI() {
		if (miRestTemplateConfigAPI == null) {
			RequestConfig config = RequestConfig.custom().setConnectTimeout(timeOutAPI)
					.setConnectionRequestTimeout(readTimeOutAPI).setSocketTimeout(timeOutAPI).build();
			CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
			miRestTemplateConfigAPI = new RestTemplate(new HttpComponentsClientHttpRequestFactory(client));
		}
		return miRestTemplateConfigAPI;
	}


}
