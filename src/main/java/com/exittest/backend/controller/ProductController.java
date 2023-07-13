package com.exittest.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exittest.backend.model.Product;
import com.exittest.backend.service.ProductService;


/**
 * @author aryanverma
 * Controller class for handling product-related operations.
 */
@CrossOrigin
@RequestMapping("/api")
@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * Retrieves all products.
	 *
	 * @return The list of all products.
	 */
	@GetMapping("/all-products")
	public List<Product> getAllProduct()
	{
		return this.productService.getProduct();
	}
	/**
	 * Adds a new product.
	 *
	 * @param product The product to add.
	 * @return The added product.
	 */
	@PostMapping("/add-products")
	public Product addProduct(@RequestBody Product product)
	{
		return this.productService.addProduct(product);
	}
	
	/**
	 * Retrieves products by their name.
	 *
	 * @param productName The name of the product to search for.
	 * @return The response entity containing the matching products or an error status.
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/search/{productName}")
	public ResponseEntity getproductByName(@PathVariable String productName)
	{
		List<Product>  product = this.productService.getProductByName(productName);

		if (product == null) {
			return ResponseEntity.status(401).build();
		}
		return ResponseEntity.status(200).body(product);
	}
	/**
	 * Retrieves a product by its ID.
	 *
	 * @param id The ID of the product to retrieve.
	 * @return The product with the specified ID.
	 */
	@GetMapping("/product/{id}")
	public Product productById(@PathVariable int id)
	{
		return this.productService.getProductById(id);
	}
	/**
	 * Retrieves the count of products.
	 *
	 * @return The number of products.
	 */
	@GetMapping("/count-products")
	public Long getProductCount()
	{
		return this.productService.getNumberofProducts();
	}
}
