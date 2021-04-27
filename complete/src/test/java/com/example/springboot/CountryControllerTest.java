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

public class CountryControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getPakistan() throws Exception {
        ObjectMapper obj = new ObjectMapper();
        String jsonStr = obj.writeValueAsString( new Country (5, "Pakistan", 220892340));
        mvc.perform(MockMvcRequestBuilders.get("/countries/5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(jsonStr));
    }

    @Test
    public void getAllCountries() throws Exception {
        ObjectMapper obj = new ObjectMapper();
        String jsonStr = "[{\"id\":1,\"name\":\"China\",\"population\":1439323776}," +
                "{\"id\":2,\"name\":\"India\",\"population\":1380004385}," +
                "{\"id\":3,\"name\":\"United States\",\"population\":331002651}," +
                "{\"id\":4,\"name\":\"Indonesia\",\"population\":273523615}," +
                "{\"id\":5,\"name\":\"Pakistan\",\"population\":220892340}," +
                "{\"id\":6,\"name\":\"Brazil\",\"population\":212559417}," +
                "{\"id\":7,\"name\":\"Nigeria\",\"population\":206139589}," +
                "{\"id\":8,\"name\":\"Bangladesh\",\"population\":164689383}," +
                "{\"id\":9,\"name\":\"Russia\",\"population\":145934462}," +
                "{\"id\":10,\"name\":\"Mexico\",\"population\":128932753}]";

        mvc.perform(MockMvcRequestBuilders.get("/countries").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonStr));
    }
}
