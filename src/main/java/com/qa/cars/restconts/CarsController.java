package com.qa.cars.restconts;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cars.domains.Cars;
import com.qa.cars.dtos.CarsDTO;
import com.qa.cars.services.CarsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CarsController {

	private CarsService service;

	@Autowired
	public CarsController(CarsService service) {
		super();
		this.service = service;
	}

	@RequestMapping(path = "/test", method = RequestMethod.GET) // Project is up and running.
	public String hello() {
		return "Welcome, to my AutoShow Website!";
	}

	@PostMapping("/create")
	public CarsDTO createCar(@RequestBody Cars car) {
		return this.service.createCar(car);
	}

	@GetMapping("/find/{id}")
	public CarsDTO find(@PathVariable int id) {
		return this.service.findCar(id);
	}

	@GetMapping("/")
	public List<CarsDTO> getCars() {
		return this.service.getCars();
	}

	@GetMapping("/findByMake/{make}")
	public List<Cars> findByMake(@PathVariable String make) {
		return this.service.findByMake(make);
	}

	@PutMapping("/update/{id}")
	public CarsDTO updateCar(@RequestBody Cars car, @PathVariable int id) {
		return this.service.updateCar(id, car);
	}

	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable int id) {
		return this.service.delete(id);
	}

}
