package co.com.xmen.controller.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ValidADNRequest {

	@Schema(description = "Representan cada fila de una tabla de (NxN) con la secuencia del ADN.", example = "[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]")
	public String[] dna;

}
