package com.terrapipe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terrapipe.app.model.entity.Country;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<Country>> allCountries() {
        return ResponseEntity.ok(terraService.allCountry());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Country> findCountry(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findCountryById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        Country countryCreated = terraService.saveCountry(country);
        return  ResponseEntity.ok(countryCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Country> deleteCountry(@PathVariable Integer id)  {

        Country countryDelete = terraService.findCountryById(id);
        terraService.deleteCountryById(id);;
        return ResponseEntity.ok( countryDelete);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Country> editCountry(@PathVariable Integer id, @RequestBody  Country country) {
        Country countryExist = terraService.findCountryById(id);
            terraService.updateCountry(countryExist);
            return ResponseEntity.ok(countryExist);

    }
}
