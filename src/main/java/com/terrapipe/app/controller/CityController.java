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

import com.terrapipe.app.model.entity.City;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<City>> allCities() {
        return ResponseEntity.ok(terraService.allCities());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<City> findCity(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findCityById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City cityCreated = terraService.saveCity(city);
        return  ResponseEntity.ok(cityCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Integer id)  {

        City cityDelete = terraService.findCityById(id);
        terraService.deleteCityById(id);;
        return ResponseEntity.ok( cityDelete);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> editCity(@PathVariable Integer id, @RequestBody  City city) {
        City cityExist = terraService.findCityById(id);
            terraService.updateCity(cityExist);
            return ResponseEntity.ok(cityExist);

    }
}
