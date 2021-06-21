package com.qa.cars.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.cars.domains.Category;
import com.qa.cars.dtos.CategoryDTO;
import com.qa.cars.repos.CategoryRepo;
import com.qa.cars.utilities.CategoriesMapper;

@Service
public class CategoryService {

	private CategoryRepo repo;

	private CategoriesMapper mapper;

	public CategoryService(CategoryRepo repo, CategoriesMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public CategoryDTO createCategory(Category cat) {
		Category saved = this.repo.save(cat);
		return this.mapper.mapToDTO(saved);
	}

	public CategoryDTO findCategory(Integer id) {
		Optional<Category> optionalCategory = this.repo.findById(id);
		Category found = optionalCategory.orElseThrow(() -> new EntityNotFoundException());
		return this.mapper.mapToDTO(found);
	}

	public CategoryDTO updateCategory(Integer id, Category newData) {
		Category existing = this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException());

		existing.setName(newData.getName());

		Category updated = this.repo.save(existing);

		return this.mapper.mapToDTO(updated);
	}

	public boolean deleteCategory(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public List<CategoryDTO> getCategories() {
		List<Category> categories = this.repo.findAll();

		List<CategoryDTO> dtos = new ArrayList<>();

		for (Category cat : categories) {
			CategoryDTO dto = this.mapper.mapToDTO(cat);
			dtos.add(dto);
		}
		return dtos;
	}
}
