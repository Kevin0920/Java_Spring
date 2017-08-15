package com.coding.ProductsCate.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coding.ProductsCate.models.Category;
import com.coding.ProductsCate.models.Product;
import com.coding.ProductsCate.repositories.CategoryRepository;
import com.coding.ProductsCate.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public void createProduct(Product product) {
		productRepository.save(product);
	}

	public Product createProduct(Long id) {
		return productRepository.findOne(id);
	}
	

	
	public List<Category> findAllCate() {
		return (List<Category>) categoryRepository.findAll();
	}

	public List<Product> findAllPro() {
		return (List<Product>) productRepository.findAll();
	}

	public void addProductToCategory(Long proId, Long id) {
		Category category = categoryRepository.findOne(id);
		Product product = productRepository.findOne(proId);
		List<Product> products = category.getProducts();
		products.add(product);
		categoryRepository.save(category);		
	}



	
	
}
