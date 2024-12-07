package com.rmnlcn.Wrestle_Backend.repositories;

import com.rmnlcn.Wrestle_Backend.entities.Continent;
import org.hibernate.type.descriptor.jdbc.NVarcharJdbcType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {
    @Query("SELECT c FROM Continent c WHERE c.nameContinent = :nameContinent")
    List<Continent> FindByName(@Param("nameContinent") NVarcharJdbcType nameContinent);
}