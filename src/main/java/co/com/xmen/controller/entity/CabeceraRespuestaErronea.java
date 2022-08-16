package co.com.xmen.controller.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CabeceraRespuestaErronea {

	@Schema(title = "Código de error, cuando status es ER")
	private String codigo;
	@Schema(title = "Descripción de error, cuando status es ER")
	private String descripcion;
	@Schema(title = "Estado de la transacción")
	private String tipo;

	public static CabeceraRespuestaErronea crearCabeceraErronea(String errorCode, String descripcionError) {
		return CabeceraRespuestaErronea.builder().tipo("ER").descripcion(descripcionError).codigo(errorCode).build();
	}

}