package com.qa.cars.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.cars.domains.category;

@Repository
	public interface CategoryRepo extends JpaRepository<category, Integer> {
}