package com.qa.cars.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.cars.domains.category;
import com.qa.cars.dtos.CategoryDTO;
import com.qa.cars.repos.CategoryRepo;
import com.qa.cars.utilities.CategoryMapper;

@Service
public class CategoryService {

	private CategoryRepo repo;

	private CategoryMapper mapper;

	public CategoryService(CategoryRepo repo, CategoryMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	public CategoryDTO createCategory(category cat) {
		category saved = this.repo.save(cat);
		return this.mapper.mapToDTO(saved);
	}

	public CategoryDTO find(Integer id) {
		Optional<category> optionalCategory = this.repo.findById(id);
		category found = optionalCategory.orElseThrow(() -> new EntityNotFoundException());
		return this.mapper.mapToDTO(found);
	}

	public CategoryDTO updateCategory(Integer id, category newData) {
		category existing = this.repo.findById(id).orElseThrow(() -> new EntityNotFoundException());

		existing.setName(newData.getName());

		category updated = this.repo.save(existing);

		return this.mapper.mapToDTO(updated);
	}

	public boolean deleteCategory(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	public List<CategoryDTO> getCategories() {
		List<category> categories = this.repo.findAll();

		List<CategoryDTO> dtos = new ArrayList<>();

		for (category cat : categories) {
			CategoryDTO dto = this.mapper.mapToDTO(cat);
			dtos.add(dto);
		}
		return dtos;
	}
}
