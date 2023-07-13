package com.exittest.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exittest.backend.model.Product;

@Repository
/**
 * @author aryanverma
 * ProductDao is a repository interface for performing CRUD operations on Product entities.
 */
public interface ProductDao extends JpaRepository<Product, Integer> {

	/**
	 * Retrieves products by their name.
	 *
	 * @param productName The name of the products to retrieve.
	 * @return A list of products with the specified name.
	 */
	public List<Product> findByProductName(String productName);

	/**
	 * Retrieves a product by its ID.
	 *
	 * @param productId The ID of the product to retrieve.
	 * @return The product with the specified ID.
	 */
	public Product findByProductId(int productId);
}
