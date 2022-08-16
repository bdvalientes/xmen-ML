package co.com.xmen.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import co.com.xmen.Utils.Utils;
import co.com.xmen.controller.entity.CabeceraRespuestaErronea;
import co.com.xmen.controller.entity.StatisticsADNResponse;
import co.com.xmen.controller.entity.ValidADNRequest;
import co.com.xmen.handler.exceptions.BadRequest400Exception;
import co.com.xmen.handler.exceptions.NotForbidden403Exception;
import co.com.xmen.models.Adn;
import co.com.xmen.repository.AdnRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ADNServiceImpl implements ADNService {

	@Autowired
	private AdnRepository adnRepository;

	public Utils util;

	public Gson gson;

	public ADNServiceImpl() {
		super();
		this.util = new Utils();
		gson = new Gson();
	}

	@Override
	public CabeceraRespuestaErronea validADN(ValidADNRequest validADNRequest) {
		// TODO Auto-generated method stub
		Adn adnBD = new Adn();
		if (isMutant(validADNRequest.getDna())) {
			adnBD.setAdn(gson.toJson(validADNRequest.dna));
			adnBD.setIsmutant(true);
			adnRepository.save(adnBD);
			return new CabeceraRespuestaErronea("200", "Cadena ADN Mutante", "OK");
		} else {
			adnBD.setAdn(gson.toJson(validADNRequest.dna));
			adnBD.setIsmutant(false);
			adnRepository.save(adnBD);
			throw new NotForbidden403Exception("ER", "203", "Cadena ADN Humana.");
		}

	}

	@Override
	public StatisticsADNResponse statisticsADN() {
		// TODO Auto-generated method stub
		StatisticsADNResponse response = new StatisticsADNResponse();
		Integer isNotMutant = adnRepository.countByismutant(false);
		Integer isMutant = adnRepository.countByismutant(true);
		response.setCount_human_dna(isNotMutant);
		response.setCount_mutant_dna(isMutant);
		if (isNotMutant > 0) {
			response.setRatio(new Float(isMutant) / new Float(isNotMutant));
		} else {
			response.setRatio(0);
		}
		return response;
	}

	public boolean isMutant(String[] adns) {
		// Validaciones basicas
		ValidBasicADN(adns);
		// Validando cadena
		String auxVertical = "";
		String auxhorizontal = "";
		String auxOblicuaP = "";
		String auxOblicuaS = "";
		String auxOblicuaPS = "";
		String auxOblicuaPI = "";
		String auxOblicuaSS = "";
		String auxOblicuaSI = "";
		for (int fila = 0; fila < adns.length; fila++) {
			String[] letras = adns[fila].split("");
			for (int column = 0; column < letras.length; column++) {
				auxhorizontal += adns[fila].split("")[column];
				auxVertical += adns[column].split("")[fila];
				// Valid Horizontal

				if (this.util.validStringADN(auxhorizontal)) {
					log.debug("***************HORIZONTAL[" + auxhorizontal + "]*********************");
					return true;
				}
				// Valid Vertical
				if (this.util.validStringADN(auxVertical)) {
					log.debug("***************VERTICAL[" + auxVertical + "]********************");
					return true;
				}
				// Valid Oblicua Principal
				if (fila == column) {
					auxOblicuaP += adns[column].split("")[column];
					if (this.util.validStringADN(auxOblicuaP)) {
						log.debug("***************auxOblicuaP[" + auxOblicuaP + "]********************");
						return true;
					}
				}
				// Valid Oblicua Secundaria
				if (fila + column == adns.length - 1) {
					auxOblicuaS += adns[fila].split("")[column];
					if (this.util.validStringADN(auxOblicuaS)) {
						log.debug("***************auxOblicuaS[" + auxOblicuaS + "]********************");
						return true;
					}
				}
				// Valid Oblicua Principal Superior
				int aux = fila + column + 1;
				if (aux < adns.length) {
					auxOblicuaPS += adns[column].split("")[aux];
					if (this.util.validStringADN(auxOblicuaPS)) {
						log.debug("***************auxOblicuaPS[" + auxOblicuaPS + "]********************");
						return true;
					}
				}

				// Valid Oblicua Principal Inferior
				if (aux < adns.length) {
					auxOblicuaPI += adns[aux].split("")[column];
					if (this.util.validStringADN(auxOblicuaPI)) {
						log.debug("***************auxOblicuaPI[" + auxOblicuaPI + "]********************");
						return true;
					}
				}
				// Valid Oblicua Secundaria Superior
				int auxSS = adns.length - fila - column - 1;
				if (auxSS >= 0) {
					auxOblicuaSS += adns[column].split("")[auxSS];
					if (this.util.validStringADN(auxOblicuaSS)) {
						log.debug("***************auxOblicuaSS[" + auxOblicuaSS + "]********************");
						return true;
					}

				}
				// Valid Oblicua Secundaria Inferios
				int auxSI = adns.length + fila - column - 1;
				if (auxSI < adns.length) {
					auxOblicuaSI += adns[column].split("")[auxSI];
					if (this.util.validStringADN(auxOblicuaSI)) {
						log.debug("***************auxOblicuaSI[" + auxOblicuaSI + "]********************");
						return true;
					}
				}
			}
			auxVertical = "";
			auxhorizontal = "";
			auxOblicuaPS = "";
			auxOblicuaPI = "";
			auxOblicuaSS = "";
			auxOblicuaSI = "";
		}
		return false;
	}

	public void ValidBasicADN(String[] adns) {
		String message = "";
		Integer lengthADN = adns.length;
		if (lengthADN >= 4) {
			for (int i = 0; i < adns.length; i++) {
				String adn = adns[i];
				if (adn.length() != lengthADN) {
					// Error de tamaño de cadena
					message = message.concat("La Cadena " + StringUtils.trimToEmpty(adn) + " con la posicion ("
							+ (i + 1) + "), no corresponde con la dimension (NXN). \n");
				} else {
					if (this.util.validValue(adn)) {
						// Error de datos
						message = message.concat("La Cadena " + StringUtils.trimToEmpty(adn) + " con la posicion ("
								+ (i + 1) + "), no contiene valores permitidos (A,T,C,G). \n");
					}
				}
			}
			if (message.length() > 0) {
				Adn adnBD = new Adn();
				adnBD.setAdn(gson.toJson(adns));
				adnBD.setIsmutant(false);
				adnRepository.save(adnBD);
				throw new BadRequest400Exception(message, "400", message);
			}
		} else {
			Adn adnBD = new Adn();
			adnBD.setAdn(gson.toJson(adns));
			adnBD.setIsmutant(false);
			adnRepository.save(adnBD);
			throw new BadRequest400Exception("Cadena de ADN invalida.", "400", "Cadena de ADN invalida.");
		}

	}

}
