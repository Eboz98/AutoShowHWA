package com.qa.cars.dtos;

public class CarsDTO {
	private Integer id;

	private String make;

	private String model;

	private String colour;

	public CarsDTO() {

	}

	public CarsDTO(Integer id, String make, String model, String colour) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.colour = colour;
	}

	public CarsDTO(String make, String model, String colour) {
		super();
		this.make = make;
		this.model = model;
		this.colour = colour;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

}
