package com.coding.ProductsCate.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coding.ProductsCate.models.Category;
import com.coding.ProductsCate.models.Product;
import com.coding.ProductsCate.repositories.CategoryRepository;
import com.coding.ProductsCate.repositories.ProductRepository;

@Service
public class CategoryService {
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	public CategoryService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public void createCategory(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> findAllCate() {
		return (List<Category>) categoryRepository.findAll();
	}

	public void addProductToCategory(Long proId, Long id) {
		Category category = categoryRepository.findOne(id);
		Product product = productRepository.findOne(proId);
		List<Product> products = category.getProducts();
		products.add(product);
		categoryRepository.save(category);		
	}

	public Category createCategory(Long id) {
		return categoryRepository.findOne(id);
	}

	public void addCategoryToProduct(Long cateId, Long id) {
		Product product = productRepository.findOne(id);
		Category category = categoryRepository.findOne(cateId);
		List<Category> categories = product.getCategories(); 
		categories.add(category);
		productRepository.save(product);
		
	}
	

	
	
	
	


	

}
