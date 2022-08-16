package co.com.xmen.Utils;

public class Utils {

	public boolean validValue(String value) {
		String[] letras = value.split("");
		for (String letra : letras) {
			switch (letra.toUpperCase()) {
			case "A":
				break;
			case "T":
				break;
			case "C":
				break;
			case "G":
				break;
			default:
				return true;
			}
		}
		return false;
	}

	public boolean validStringADN(String value) {
		if (value.contains(Constant.CADENA_AAAA) || value.contains(Constant.CADENA_CCCC)
				|| value.contains(Constant.CADENA_GGGG) || value.contains(Constant.CADENA_TTTT)) {
			return true;
		}
		return false;
	}
}
