package com.exittest.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "review")
/**
 * @author aryanverma
 * ProductReview class represents a product review entity.
 */
public class ProductReview {
	public ProductReview() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	private String review;
	private String rating;
	private String state;

	/**
	 * Retrieves the state of the product review.
	 *
	 * @return The state of the product review.
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state of the product review.
	 *
	 * @param state The state of the product review.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Retrieves the rating of the product review.
	 *
	 * @return The rating of the product review.
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * Sets the rating of the product review.
	 *
	 * @param rating The rating of the product review.
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}

	@ManyToOne
	@JsonIgnoreProperties("review")
	private Product product;

	/**
	 * Retrieves the review ID.
	 *
	 * @return The review ID.
	 */
	public int getReviewId() {
		return reviewId;
	}

	/**
	 * Sets the review ID.
	 *
	 * @param reviewId The review ID.
	 */
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	/**
	 * Retrieves the review text.
	 *
	 * @return The review text.
	 */
	public String getReview() {
		return review;
	}

	/**
	 * Sets the review text.
	 *
	 * @param review The review text.
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * Retrieves the associated product.
	 *
	 * @return The associated product.
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Sets the associated product.
	 *
	 * @param product The associated product.
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductReview [reviewId=" + reviewId + ", review=" + review + ", rating=" + rating + ", state=" + state
				+ ", product=" + product + "]";
	}
}
