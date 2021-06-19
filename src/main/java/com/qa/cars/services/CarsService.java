package com.qa.cars.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.cars.domains.Cars;
import com.qa.cars.repos.CarsRepo;

@Service
public class CarsService {

	private CarsRepo repo;

	@Autowired
	public CarsService(CarsRepo repo) {
		super();
		this.repo = repo;
	}

	public Cars createCar(Cars car) {
		return this.repo.save(car);
	}

	public Cars findCar(Integer id) {
		Optional<Cars> optionalCar = this.repo.findById(id);
		return optionalCar.orElseThrow(() -> new EntityNotFoundException());
	}

	public List<Cars> findByMake(String make) {
		return this.repo.findByMakeIgnoreCase(make);
	}

	public Cars updateCar(Integer id, Cars newData) {
		Cars existing = this.findCar(id);
		existing.setMake(newData.getMake());
		existing.setModel(newData.getModel());
		existing.setColour(newData.getColour());

		Cars updated = this.repo.save(existing); // Overwrites !

		return updated;
	}

	public boolean delete(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public List<Cars> getCars() {
		return this.repo.findAll();
	}

}
