package com.qa.cars.dtos;

import java.util.List;

import com.qa.cars.dtos.CarsDTO;

public class CategoryDTO {
	
	private Integer id;

	private String name;

	private List<CarsDTO> cars;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CarsDTO> getCars() {
		return cars;
	}

	public void setCars(List<CarsDTO> cars) {
		this.cars = cars;
	}

}
