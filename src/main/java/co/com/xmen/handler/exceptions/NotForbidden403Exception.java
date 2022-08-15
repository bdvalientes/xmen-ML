package co.com.xmen.handler.exceptions;

import lombok.Getter;

@Getter
public class NotForbidden403Exception extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String codigoError;
	private final String descripcionUsuario;

	public NotForbidden403Exception(String message) {
		super(message);
		this.codigoError = "";
		this.descripcionUsuario = "";

	}

	public NotForbidden403Exception(String message, String codigoError, String descripcionUsuario) {
		super(message);
		this.codigoError = codigoError;
		this.descripcionUsuario = descripcionUsuario;

	}

	public NotForbidden403Exception() {
		super("En este momento no podemos atenderlo");
		this.codigoError = "00001";
		this.descripcionUsuario = "En este momento no podemos atenderlo";
	}

}