package com.qa.cars.restconts;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {
	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String hello() {
		return "Welcome, to my AutoShow Website!";
	}
}
