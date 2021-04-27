package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    public static Country[] countries = {
            new Country (1, "China", 1439323776),
            new Country (2, "India", 1380004385),
            new Country (3, "United States", 331002651),
            new Country (4, "Indonesia", 273523615),
            new Country (5, "Pakistan", 220892340),
            new Country (6, "Brazil", 212559417),
            new Country (7, "Nigeria", 206139589),
            new Country (8, "Bangladesh", 164689383),
            new Country (9, "Russia", 145934462),
            new Country (10, "Mexico", 128932753),
    };

    @GetMapping("/countries")
    public Country[] countries() {
        return countries;
    }

    @GetMapping("/countries/{id}")
    public Country country(@PathVariable("id") int countryId) {
        int idAux = countryId - 1;
        return countries[idAux];
    }
    
}
