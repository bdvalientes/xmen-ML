package co.com.xmen.service;

import org.springframework.stereotype.Service;

import co.com.xmen.Utils.Utils;
import co.com.xmen.controller.entity.CabeceraRespuestaErronea;
import co.com.xmen.controller.entity.ValidADNRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ADNServiceImpl implements ADNService {

	public Utils util;

	public ADNServiceImpl() {
		super();
		this.util = new Utils();
	}

	@Override
	public CabeceraRespuestaErronea validADN(ValidADNRequest validADNRequest) {
		// TODO Auto-generated method stub
		log.debug(validADNRequest.getDna().toString());
		this.util.ValidADN(validADNRequest.getDna());
		return null;
	}

}
