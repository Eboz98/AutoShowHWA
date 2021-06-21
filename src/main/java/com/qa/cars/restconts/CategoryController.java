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
import org.springframework.web.bind.annotation.RestController;

import com.qa.cars.domains.Category;
import com.qa.cars.dtos.CategoryDTO;
import com.qa.cars.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private CategoryService service;

	@Autowired
	public CategoryController(CategoryService service) {
		super();
		this.service = service;
	}

	@GetMapping("/test")
	public String testCategory() {
		return "These are the categories!";
	}

	@PostMapping("/create")
	public CategoryDTO createCategory(@RequestBody Category cat) {
		return this.service.createCategory(cat);
	}

	@GetMapping("/find/{id}")
	public CategoryDTO findCategory(@PathVariable int id) {
		return this.service.findCategory(id);
	}

	@GetMapping("/")
	public List<CategoryDTO> getCategories() {
		return this.service.getCategories();
	}

	@PutMapping("/update/{id}")
	public CategoryDTO updateCategory(@RequestBody Category cat, @PathVariable int id) {
		return this.service.updateCategory(id, cat);
	}

	@DeleteMapping("/remove/{id}")
	public boolean deleteCategory(@PathVariable int id) {
		return this.service.deleteCategory(id);
	}

}