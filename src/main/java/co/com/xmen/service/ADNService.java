package co.com.xmen.service;

import co.com.xmen.controller.entity.CabeceraRespuestaErronea;
import co.com.xmen.controller.entity.StatisticsADNResponse;
import co.com.xmen.controller.entity.ValidADNRequest;

public interface ADNService {

	public CabeceraRespuestaErronea validADN(ValidADNRequest validADNRequest);

	public StatisticsADNResponse statisticsADN();

}
