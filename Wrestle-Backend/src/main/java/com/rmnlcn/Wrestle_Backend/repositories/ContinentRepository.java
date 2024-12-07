package com.rmnlcn.Wrestle_Backend.repositories;

import com.rmnlcn.Wrestle_Backend.entities.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {
    @Query("SELECT * FROM Continent")
    List<Continent> getAllContinents();

    @Query("SELECT c FROM Continent c WHERE c.id = :id")
    Continent getContinentById(@Param("id") Long id);

    /*@Query("SELECT c FROM Continent c WHERE c.name = :name")
    List<Continent> FindByName(@Param("name") String name);*/
}
