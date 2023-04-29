package com.md.estate.repository;

import com.md.estate.model.Customer;
import com.md.estate.model.Estate;
import com.md.estate.model.EstateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Long> {

    List<Estate> findByEstateType(EstateType estateType);

    List<Estate> findBySquareMetersGreaterThan(double squareMeters);

    List<Estate> findByRoomNumberGreaterThanEqual(int roomNumber);

    List<Estate> findByFloorNumberLessThanEqual(int floorNumber);

    List<Estate> findByCustomer(Customer customer);

    List<Estate> findByHeatingSystem(String heatingSystem);
}
