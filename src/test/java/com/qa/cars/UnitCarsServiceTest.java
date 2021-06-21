package com.qa.cars;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.cars.domains.Cars;
import com.qa.cars.repos.CarsRepo;
import com.qa.cars.services.CarsService;

@SpringBootTest
@ActiveProfiles("test")
class UnitCarsServiceTest {

	@Autowired
	private CarsService ser;

	@MockBean
	private CarsRepo rep;

	@Test
	void testUpdate() {

		// User Stoyr: AS an owner, I WANT to be able to edit an existing car SO I can
		// change
		// details of the car.

		// GIVEN -- I have edit button
		Integer testId = 1;
		Cars testData = new Cars("Toyota", "cellica", "black");
		Cars existing = new Cars(1, null, null, null);
		Cars updatedCar = new Cars(testId, "Toyota", "cellica", "black");

		// WHEN -- I click the button change details. And able to see details of the
		// existing.
		Mockito.when(this.rep.findById(testId)).thenReturn(Optional.of(existing));
		Mockito.when(this.rep.save(updatedCar)).thenReturn(updatedCar);

		// THEN -- I should see details of the car and able to edit them.
//		assertThat(this.ser.updateCar(testId, testData)).isEqualTo(updatedCar);
//
//		Mockito.verify(this.rep, Mockito.times(1)).findById(testId);
//		Mockito.verify(this.rep, Mockito.times(1)).save(updatedCar);
	}

	@Test
	void testDelete() {

		// User Story: AS an owner, I WANT to be able to delete an existing car SO I can
		// get rid of it once I do not need it.

		// GIVEN -- I have delete button
		Integer testId = 1;
		boolean exists = false;

		// WHEN -- I click the button AND finds by ID.
		Mockito.when(this.rep.existsById(testId)).thenReturn(exists);

		// THEN -- it should delete the car from the list
		assertThat(this.ser.delete(testId)).isEqualTo(!exists);

		Mockito.verify(this.rep, Mockito.times(1)).existsById(testId);
	}

}
