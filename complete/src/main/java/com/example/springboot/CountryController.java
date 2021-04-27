package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

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
