package co.com.xmen;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.xmen.controller.entity.ValidADNRequest;

@SpringBootTest
class XmenApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webContext;

	private ObjectMapper mapper;

	@BeforeEach
	void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
	}

	@Test
	void postMutantIsOK() throws Exception {
		ValidADNRequest validADNRequest = new ValidADNRequest();
		validADNRequest.setDna(new String[] { "TTGCTT", "CAGTTC", "TTATTC", "AGAAGC", "TTATGC", "AGGAGA" });
		mapper = new ObjectMapper();
		mockMvc.perform(post("/v1/adn/mutant").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(validADNRequest))).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void postMutantIsBadRequestInvalidCaracter() throws Exception {
		ValidADNRequest validADNRequest = new ValidADNRequest();
		validADNRequest.setDna(new String[] { "TTGCTO", "CAGTTC", "TTATTC", "AGAAGC", "TTATGC", "AGGAGA" });
		mapper = new ObjectMapper();
		mockMvc.perform(post("/v1/adn/mutant").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(validADNRequest))).andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void postMutantIsBadRequestInvalidLentgh1() throws Exception {
		ValidADNRequest validADNRequest = new ValidADNRequest();
		validADNRequest.setDna(new String[] { "TTG", "CAG", "TTA" });
		mapper = new ObjectMapper();
		mockMvc.perform(post("/v1/adn/mutant").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(validADNRequest))).andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void postMutantIsBadRequestInvalidLentgh2() throws Exception {
		ValidADNRequest validADNRequest = new ValidADNRequest();
		validADNRequest.setDna(new String[] { "TTGT", "CAGT", "TTAT", "TTA" });
		mapper = new ObjectMapper();
		mockMvc.perform(post("/v1/adn/mutant").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(validADNRequest))).andDo(print()).andExpect(status().isBadRequest());
	}

	@Test
	void postMutantIsForbidden() throws Exception {
		ValidADNRequest validADNRequest = new ValidADNRequest();
		validADNRequest.setDna(new String[] { "TTGCTT", "CAGTTC", "TTATTC", "AGAAGA", "TTATGC", "AGGAGA" });
		mapper = new ObjectMapper();
		mockMvc.perform(post("/v1/adn/mutant").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsBytes(validADNRequest))).andDo(print()).andExpect(status().isForbidden());
	}

	@Test
	void getStatsIsOK() throws Exception {
		mockMvc.perform(get("/v1/adn/stats").contentType(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(status().isOk());
	}

}
