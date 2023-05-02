package com.md.estate.repository;

import com.md.estate.model.Estate;
import com.md.estate.model.EstateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Long> {

    List<Estate> findByEstateType(EstateType estateType);
    @Query("SELECT e FROM Estate e WHERE " +
            "(:estateType IS NULL OR e.estateType = :estateType) AND " +
            "(:squareMeters IS NULL OR e.squareMeters >= :squareMeters) AND " +
            "(:roomNumber IS NULL OR e.roomNumber >= :roomNumber) AND " +
            "(:floorNumber IS NULL OR e.floorNumber <= :floorNumber) AND " +
            "(:heatingSystem IS NULL OR e.heatingSystem = :heatingSystem)")
    List<Estate> searchEstate(@Param("estateType") EstateType estateType,
                        @Param("squareMeters") Double squareMeters,
                        @Param("roomNumber") Integer roomNumber,
                        @Param("floorNumber") Integer floorNumber,
                        @Param("heatingSystem") String heatingSystem);

}
