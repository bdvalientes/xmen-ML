package co.com.xmen.controller;

import org.springframework.http.ResponseEntity;

import co.com.xmen.controller.entity.CabeceraRespuestaErronea;
import co.com.xmen.controller.entity.ValidADNRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "ADN", description = "Funcionalidades para una cadena de ADN")
public interface IXMen {

	@Operation(summary = "Valida una cadena de ADN.", description = "Valida los datos de una cadena de ADN, para identificar si es, un humano Mutante o No Mutante.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = CabeceraRespuestaErronea.class))),
			@ApiResponse(responseCode = "400", description = "Error Validacion", content = @Content(schema = @Schema(implementation = CabeceraRespuestaErronea.class))),
			@ApiResponse(responseCode = "401", description = "No Autorizado", content = @Content(schema = @Schema(implementation = CabeceraRespuestaErronea.class))),
			@ApiResponse(responseCode = "500", description = "Error Tecnico", content = @Content(schema = @Schema(implementation = CabeceraRespuestaErronea.class))),
			@ApiResponse(responseCode = "403", description = "ADN No Validado", content = @Content(schema = @Schema(implementation = CabeceraRespuestaErronea.class))), })
	public ResponseEntity<?> validADN(@RequestBody ValidADNRequest validADNRequest);

}
