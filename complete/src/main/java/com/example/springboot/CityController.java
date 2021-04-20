package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springboot.City;

@RestController
public class HelloController {

	@RequestMapping("/cities")
	public City[] cities() {
		return cities;
	}

}
