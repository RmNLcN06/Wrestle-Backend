package com.rmnlcn.Wrestle_Backend.controllers;

import com.rmnlcn.Wrestle_Backend.entities.Continent;
import com.rmnlcn.Wrestle_Backend.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/continents")
@CrossOrigin(origins = "http://localhost:4200")
public class ContinentController {
    @Autowired
    private final ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping
    public List<Continent> getAllContinents() {
        return continentService.getAllContinents();
    }

    @GetMapping("/{id}")
    public Continent getContinentById(@PathVariable Long idContinent) {
        return continentService.getContinentById(idContinent);
    }

    @PostMapping
    public Continent createContinent(@RequestBody Continent continent) {
        return continentService.createContinent(continent);
    }

    @PutMapping("/{id}")
    public Continent updateContinent(@PathVariable Long idContinent, @RequestBody Continent continentDetails) {
        return continentService.updateContinent(idContinent, continentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteContinent(@PathVariable Long idContinent) {
        continentService.deleteContinent(idContinent);
    }
}
