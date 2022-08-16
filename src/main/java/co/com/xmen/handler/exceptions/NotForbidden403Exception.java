package co.com.xmen.handler.exceptions;

import lombok.Getter;

@Getter
public class NotForbidden403Exception extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String codigoError;
	private final String descripcionUsuario;

	public NotForbidden403Exception(String message, String codigoError, String descripcionUsuario) {
		super(message);
		this.codigoError = codigoError;
		this.descripcionUsuario = descripcionUsuario;

	}

}