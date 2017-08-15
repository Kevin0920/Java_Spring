package com.coding.ProductsCate.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding.ProductsCate.models.Category;
import com.coding.ProductsCate.models.Product;
import com.coding.ProductsCate.services.CategoryService;
import com.coding.ProductsCate.services.ProductService;



@Controller
public class ProductCon {
	private ProductService productService;
	private CategoryService categoryService;
	
	public ProductCon(ProductService productService, CategoryService categoryService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newProduct";
	}
	
	@PostMapping("/products/new")
	public String createDojo(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct";
		} else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/categories/new")
	public String newProduct(@ModelAttribute("category") Category category) {
		return "newCategory";
	}
	
	@PostMapping("/categories/new")
	public String createDojo(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory";
		} else {
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}
	
	
	@RequestMapping("/products/{id}")
	public String findProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.createProduct(id);
		model.addAttribute("product", product);
		List<Category> categories = categoryService.findAllCate();
		model.addAttribute("categories", categories);
		return "Products";
	}
	
	@PostMapping("/products/{id}/new")
	public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam(value="category") Long cateId) {
		categoryService.addCategoryToProduct(cateId, id);
		String proUrl = "redirect:/products/" + id;
		return proUrl;
	}
	
	
	
	@RequestMapping("/categories/{id}")
	public String findCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.createCategory(id);
		model.addAttribute("category", category);
		List<Product> products = productService.findAllPro();
		return "Category";
	}
	
	@PostMapping("/categories/{id}/new")
	public String addProductToCategory(@PathVariable("id") Long id, @RequestParam(value="product") Long proId) {
		productService.addProductToCategory(proId, id);
		String cateUrl = "redirect:/categories/" + id;
		return cateUrl;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
