package co.com.xmen.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import co.com.xmen.controller.entity.CabeceraRespuestaErronea;
import co.com.xmen.handler.exceptions.BadRequest400Exception;
import co.com.xmen.handler.exceptions.NotForbidden403Exception;

@ControllerAdvice
public class ControllerErrorHandler extends ResponseEntityExceptionHandler {

	// TODO. definir objeto de respuestas erroneas.
	@ExceptionHandler(BadRequest400Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<CabeceraRespuestaErronea> backendException(BadRequest400Exception ex, WebRequest request) {
		CabeceraRespuestaErronea respuesta = CabeceraRespuestaErronea.crearCabeceraErronea(ex.getCodigoError(),
				ex.getDescripcionUsuario());
		return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotForbidden403Exception.class)
	public ResponseEntity<Object> NotFoundException(NotForbidden403Exception ex, WebRequest request) {
		CabeceraRespuestaErronea respuesta = CabeceraRespuestaErronea.crearCabeceraErronea(ex.getCodigoError(),
				ex.getDescripcionUsuario());
		return new ResponseEntity<>(respuesta, HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> lastException(Exception ex, WebRequest request) {
		CabeceraRespuestaErronea respuesta = CabeceraRespuestaErronea.crearCabeceraErronea("0001",
				"En este momento no podemos atenderlo");
		return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}