package co.com.xmen.Utils;

import org.apache.commons.lang3.StringUtils;

import co.com.xmen.handler.exceptions.BadRequest400Exception;
import lombok.Data;

@Data
public class Utils {

	public boolean isMutant(String[] adn) {
		return true;
	}

	public void ValidADN(String[] adns) {
		String message = "";
		Integer lengthADN = adns.length;
		if (lengthADN > 0) {
			for (int i = 0; i < adns.length; i++) {
				String adn = adns[i];
				if (adn.length() != lengthADN) {
					message = message.concat("La Cadena " + StringUtils.trimToEmpty(adn) + " con la posicion ("
							+ (i + 1) + "), no corresponde con la dimension (NXN). \n");
				}
			}
			if (message.length() > 0) {
				throw new BadRequest400Exception(message, "400", message);
			}
		} else {
			throw new BadRequest400Exception("Cadena de ADN invalida.", "400", "Cadena de ADN invalida.");
		}

	}

}
