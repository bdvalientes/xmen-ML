package co.com.xmen.config;

import java.io.IOException;

import org.zalando.logbook.Correlation;
import org.zalando.logbook.HttpRequest;
import org.zalando.logbook.HttpResponse;
import org.zalando.logbook.Precorrelation;
import org.zalando.logbook.Sink;
import org.zalando.logbook.HttpLogFormatter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class SinkDatabase implements Sink {

	HttpLogFormatter httpLogFormatter;

	@Override
	public void write(Precorrelation precorrelation, HttpRequest request) throws IOException {
		log.debug("Log Request:" + httpLogFormatter.format(precorrelation, request));
	}

	@Override
	public void write(Correlation correlation, HttpRequest request, HttpResponse response) throws IOException {
		log.debug("Log Response" + httpLogFormatter.format(correlation, response));
	}

}
