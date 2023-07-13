package com.exittest.backend.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.exittest.backend.dao.ProductDao;
import com.exittest.backend.model.Product;

@Service
/**
 * @author aryanverma
 * ProductService is a service class that provides methods to manage products.
 */
public class ProductService {

	@Autowired
	private ProductDao productDao;

	/**
	 * Retrieves all products.
	 *
	 * @return A list of all products.
	 */
	public List<Product> getProduct() {
		return this.productDao.findAll();
	}

	/**
	 * Adds a new product.
	 *
	 * @param product The product to be added.
	 * @return The added product.
	 */
	public Product addProduct(Product product) {

	        Product productId = this.productDao.findByProductId(product.getProductId());
	        if (productId != null) {
	            return null;
	        }
	        return this.productDao.save(product);
	  
	}

	/**
	 * Retrieves products by name.
	 *
	 * @param productName The name of the products to be retrieved.
	 * @return A list of products matching the given name.
	 */
	public List<Product> getProductByName(String productName) {
		List<Product> product = this.productDao.findByProductName(productName);
		return product;
	}

	/**
	 * Retrieves a product by its ID.
	 *
	 * @param id The ID of the product.
	 * @return The product with the specified ID.
	 */
	public Product getProductById(int id) {
		Product product = null;
		try {
			product = productDao.findByProductId(id);
		} catch (NoSuchElementException e) {
			System.out.println("No product with this ID");
		}
		return product;
	}

	/**
	 * Gets the total number of products.
	 *
	 * @return The total number of products.
	 */
	public Long getNumberofProducts() {
		return this.productDao.count();
	}

}
