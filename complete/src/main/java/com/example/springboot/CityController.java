package com.example.springboot;

import org.springframework.web.bind.annotation.*;


import com.example.springboot.City;

import java.util.ArrayList;

@RestController
public class CityController {

	public static City[] cities = {
		new City(1, "A Coruña", "A Coruña"),
		new City(2, "Ferrol", "A Coruña"),
		new City(3, "Santiago de Compostela", "A Coruña"),
		new City(4, "Lugo", "Lugo"),
		new City(5, "Ourense", "Ourense"),
		new City(6, "Pontevedra", "Pontevedra"),
		new City(7, "Vigo", "Pontevedra"),
	};

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/cities")
	public City[] cities() {
		return cities;
	}

	@GetMapping("/cities/{id}")
	public City city(@PathVariable("id") int cityId) {
		int idAux = cityId - 1;
		return cities[idAux];
	}

}
