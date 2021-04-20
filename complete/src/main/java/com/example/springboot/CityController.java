package com.example.springboot;

import org.springframework.web.bind.annotation.*;

import com.example.springboot.City;

@RestController
public class HelloController {

	@RequestMapping("/cities")
	public City[] cities() {
		return cities;
	}

	@GetMapping("/cities/{id}")
	public City cities(@PathVariable("id") int cityId) {
		int idAux = cityId - 1;
		return cities[idAux];
	}

}
