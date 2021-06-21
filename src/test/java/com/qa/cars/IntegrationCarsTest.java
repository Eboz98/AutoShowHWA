package com.qa.cars;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.cars.dtos.CarsDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:car-schema.sql",
		"classpath:car-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class IntegrationCarsTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		CarsDTO testCar = new CarsDTO("Mercedes", "E250", "silver");
		String testCarAsJSON = this.mapper.writeValueAsString(testCar);

		CarsDTO CarSaved = new CarsDTO("Mercedes", "E250", "silver");
		CarSaved.setId(2);
		String JSONCars = this.mapper.writeValueAsString(CarSaved);

		RequestBuilder mockRequest = post("/cars/create").content(testCarAsJSON)
				.contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isOk();

		ResultMatcher checkBody = content().json(JSONCars);

		this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkBody);

	}

	@Test
	void testGetAll() throws Exception {
		CarsDTO testCar = new CarsDTO(1, "Toyota", "cellica", "black");
		List<CarsDTO> testCars = List.of(testCar);
		String JSONArray = this.mapper.writeValueAsString(testCars);

		this.mvc.perform(get("/cars/")).andExpect(status().isOk()).andExpect(content().json(JSONArray));

	}

}
