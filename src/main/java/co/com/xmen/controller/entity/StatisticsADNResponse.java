package co.com.xmen.controller.entity;

import lombok.Data;

@Data
public class StatisticsADNResponse {

	public Integer count_mutant_dna;
	public Integer count_human_dna;
	public float ratio;
}
