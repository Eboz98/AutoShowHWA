package com.qa.cars.utilities;

import org.springframework.stereotype.Service;

import com.qa.cars.domains.Cars;
import com.qa.cars.dtos.CarsDTO;

@Service
public class CarsMapper implements theMapper<Cars, CarsDTO> {

	@Override
	public CarsDTO mapToDTO(Cars car) {
		CarsDTO dto = new CarsDTO();

		dto.setColour(car.getColour());
		dto.setId(car.getId());
		dto.setMake(car.getMake());
		dto.setModel(car.getModel());

		return dto;
	}

	@Override
	public Cars mapFromDTO(CarsDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}