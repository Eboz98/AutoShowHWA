package com.qa.cars.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.cars.domains.Cars;
import com.qa.cars.domains.category;
import com.qa.cars.dtos.CarsDTO;
import com.qa.cars.dtos.CategoryDTO;

@Service
public class CategoriesMapper implements theMapper<category, CategoryDTO> {

	private CarsMapper carMap;

	public CategoriesMapper(CarsMapper carMap) {
		super();
		this.carMap = carMap;
	}

	@Override
	public CategoryDTO mapToDTO(category entity) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		List<CarsDTO> cars = new ArrayList<>();
		for (Cars car : entity.getCars()) {
			cars.add(this.carMap.mapToDTO(car));
		}
		dto.setCars(cars);
		return dto;
	}

	@Override
	public category mapFromDTO(CategoryDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}