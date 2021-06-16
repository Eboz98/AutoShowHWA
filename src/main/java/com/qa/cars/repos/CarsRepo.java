package com.qa.cars.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.qa.cars.domains.Cars;

@Repository
public interface CarsRepo extends JpaRepository<Cars, Integer> { // Repository with generics for listing and find by make filtering.

	List<Cars> findByMakeIgnoreCase(String make);

}