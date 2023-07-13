package com.exittest.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "product")
/**
 * @author aryanverma
 * Product class represents a product entity.
 */
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private String brandName;
	private int code;
	
	
	@OneToMany(mappedBy = "product")
	private List<ProductReview> review;

	/**
	 * Constructs a Product object with the specified attributes.
	 *
	 * @param productId   The product ID.
	 * @param productName The product name.
	 * @param brandName   The brand name.
	 * @param code        The product code.
	 * @param review      The list of product reviews.
	 */
	public Product(int productId, String productName, String brandName, int code, List<ProductReview> review) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brandName = brandName;
		this.code = code;
		this.review = review;
	}

	/**
	 * Retrieves the list of product reviews.
	 *
	 * @return The list of product reviews.
	 */
	public List<ProductReview> getReview() {
		return review;
	}

	/**
	 * Sets the list of product reviews.
	 *
	 * @param review The list of product reviews.
	 */
	public void setReview(List<ProductReview> review) {
		this.review = review;
	}

	public Product() {}

	/**
	 * Retrieves the product ID.
	 *
	 * @return The product ID.
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Sets the product ID.
	 *
	 * @param productId The product ID.
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * Retrieves the product name.
	 *
	 * @return The product name.
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the product name.
	 *
	 * @param productName The product name.
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * Retrieves the brand name.
	 *
	 * @return The brand name.
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * Sets the brand name.
	 *
	 * @param brandName The brand name.
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * Retrieves the product code.
	 *
	 * @return The product code.
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Sets the product code.
	 *
	 * @param code The product code.
	 */
	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brandName=" + brandName
				+ ", code=" + code + ", review=" + review + "]";
	}
}
 