package com.rmnlcn.Wrestle_Backend.services;

import com.rmnlcn.Wrestle_Backend.entities.Continent;
import com.rmnlcn.Wrestle_Backend.repositories.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentService {
    @Autowired
    private final ContinentRepository continentRepository;

    public ContinentService(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }

    public Continent getContinentById(Long id) {
        return continentRepository.findById(id).orElseThrow(() -> new RuntimeException("Continent not found. Please try again."));
    }

    public Continent createContinent(Continent continent) {
        return continentRepository.save(continent);
    }

    public Continent updateContinent(Long id, Continent continentDetails) {
        Continent continent = getContinentById(id);
        continent.setName(continentDetails.getName());
        return continentRepository.save(continent);
    }

    public void deleteContinent(Long id) {
        continentRepository.deleteById(id);
    }
}
