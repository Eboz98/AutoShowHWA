package com.qa.cars.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.cars.domains.Cars;
import com.qa.cars.dtos.CarsDTO;
import com.qa.cars.repos.CarsRepo;
import com.qa.cars.utilities.CarsMapper;

@Service
public class CarsService {

	private CarsRepo repo;

	private CarsMapper mapper;

	public CarsService(CarsRepo repo, CarsMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public CarsDTO createCar(Cars car) {
		Cars saved = this.repo.save(car);
		return this.mapper.mapToDTO(saved);
	}

	public CarsDTO findCar(Integer id) {
		Optional<Cars> optionalCar = this.repo.findById(id);
		Cars found = optionalCar.orElseThrow(() -> new EntityNotFoundException());
		return this.mapper.mapToDTO(found);
	}

	public List<Cars> findByMake(String make) {
		return this.repo.findByMakeIgnoreCase(make);
	}

	public CarsDTO updateCar(Integer id, Cars newData) {
		Cars existing = this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException());

		existing.setMake(newData.getMake());
		existing.setModel(newData.getModel());
		existing.setColour(newData.getColour());

		Cars updated = this.repo.save(existing); // Overwrites !

		return this.mapper.mapToDTO(updated);
	}

	public boolean delete(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public List<CarsDTO> getCars() {
		List<Cars> cars = this.repo.findAll();
		List<CarsDTO> dtos = new ArrayList<>();

		CarsDTO dto = null;
		for (Cars car : cars) {
			dto = this.mapper.mapToDTO(car);
			dtos.add(dto);
		}

		return dtos;
	}

	private List<CarsDTO> getCars_WITH_STREAMS() { // First stream tries.
		return this.repo.findAll().stream().map(car -> this.mapper.mapToDTO(car)).collect(Collectors.toList());
	}

}
