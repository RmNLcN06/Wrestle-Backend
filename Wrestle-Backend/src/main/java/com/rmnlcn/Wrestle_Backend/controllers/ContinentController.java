package com.rmnlcn.Wrestle_Backend.controllers;

import com.rmnlcn.Wrestle_Backend.entities.Continent;
import com.rmnlcn.Wrestle_Backend.services.ContinentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/continents")
@Tag(name = "Continent API", description = "API to manage continents")
@CrossOrigin(origins = "http://localhost:4200")
public class ContinentController {
    @Autowired
    private final ContinentService continentService;

    public ContinentController(ContinentService continentService) {
        this.continentService = continentService;
    }

    @GetMapping
    @Operation(summary = "Get all continents", description = "Retrieve all continents from the database.")
    public List<Continent> getAllContinents() {
        return continentService.getAllContinents();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a continent by its ID", description = "Retrieve details of a specific continent.")
    public Continent getContinentById(@PathVariable Long id) {
        return continentService.getContinentById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new continent", description = "Add a new continent to the database.")
    public Continent createContinent(@RequestBody Continent continent) {
        continent.setId(null);
        return continentService.createContinent(continent);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing continent", description = "Update detail(s) of a specific continent.")
    public Continent updateContinent(@PathVariable Long id, @RequestBody Continent continentDetails) {
        return continentService.updateContinent(id, continentDetails);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a continent", description = "Remove a continent from the database.")
    public void deleteContinent(@PathVariable Long id) {
        continentService.deleteContinent(id);
    }
}
