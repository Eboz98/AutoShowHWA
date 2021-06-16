package com.qa.cars.restconts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qa.cars.domains.category;
import com.qa.cars.dtos.CategoryDTO;
import com.qa.cars.services.CategoriesService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private CategoriesService service;

	@Autowired
	public CategoryController(CategoriesService service) {
		super();
		this.service = service;
	}

	@RequestMapping(path = "/test", method = RequestMethod.GET)
	public String testCategory() {
		return "These are the categories!";
	}

	@PostMapping("/create")
	public CategoryDTO createCategory(@RequestBody category cat) {
		return this.service.createCategory(cat);
	}

	@GetMapping("/find/{id}")
	public CategoryDTO find(@PathVariable int id) {
		return this.service.findCategory(id);
	}

	@GetMapping("/")
	public List<CategoryDTO> getCategories() {
		return this.service.getCategories();
	}

	@PutMapping("/update/{id}")
	public CategoryDTO updateCategory(@RequestBody category cat, @PathVariable int id) {
		return this.service.updateCategory(id, cat);
	}

	@DeleteMapping("/remove/{id}")
	public boolean deleteCategory(@PathVariable int id) {
		return this.service.deleteCategory(id);
	}

}