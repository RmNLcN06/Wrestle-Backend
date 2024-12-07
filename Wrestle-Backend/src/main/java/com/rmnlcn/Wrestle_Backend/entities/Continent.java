package com.rmnlcn.Wrestle_Backend.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "continents")
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContinent;

    @Column(nullable = false)
    @NotNull(message = "Continent name cannot be null.")
    @Size(min = 3, max = 15, message = "Continent name must be between 3 and 15 characters.")
    private String nameContinent;

    /********************************************/

    // Getters & Setters
    public Long getIdContinent() {
        return idContinent;
    }

    public void setIdContinent(Long idContinent) {
        this.idContinent = idContinent;
    }

    public String getNameContinent() {
        return nameContinent;
    }

    public void setNameContinent(String nameContinent) {
        this.nameContinent = nameContinent;
    }

}
