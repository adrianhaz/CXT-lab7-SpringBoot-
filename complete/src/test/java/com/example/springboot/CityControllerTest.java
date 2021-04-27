package com.example.springboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

	@Test
	public void getFerrol() throws Exception {
		ObjectMapper obj = new ObjectMapper();
		String jsonStr = obj.writeValueAsString(new City(2, "Ferrol", "A Coruña"));
		mvc.perform(MockMvcRequestBuilders.get("/cities/2").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().json(jsonStr));
	}

	@Test
	public void getAllCities() throws Exception {
		ObjectMapper obj = new ObjectMapper();
		String jsonStr = "[{\"id\":1,\"name\":\"A Coruña\",\"province\":\"A Coruña\"}," +
				"{\"id\":2,\"name\":\"Ferrol\",\"province\":\"A Coruña\"}," +
				"{\"id\":3,\"name\":\"Santiago de Compostela\",\"province\":\"A Coruña\"}," +
				"{\"id\":4,\"name\":\"Lugo\",\"province\":\"Lugo\"}," +
				"{\"id\":5,\"name\":\"Ourense\",\"province\":\"Ourense\"}," +
				"{\"id\":6,\"name\":\"Pontevedra\",\"province\":\"Pontevedra\"}," +
				"{\"id\":7,\"name\":\"Vigo\",\"province\":\"Pontevedra\"}]";

		mvc.perform(MockMvcRequestBuilders.get("/cities").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(jsonStr));
	}
}
