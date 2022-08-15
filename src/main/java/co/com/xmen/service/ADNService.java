package co.com.xmen.service;

import co.com.xmen.controller.entity.CabeceraRespuestaErronea;
import co.com.xmen.controller.entity.ValidADNRequest;

public interface ADNService {
	
	public CabeceraRespuestaErronea validADN(ValidADNRequest validADNRequest);

}
