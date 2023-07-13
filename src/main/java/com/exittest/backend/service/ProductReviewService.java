package com.exittest.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exittest.backend.dao.ProductReviewsDao;
import com.exittest.backend.model.Product;
import com.exittest.backend.model.ProductReview;

/**
 * @author aryanverma
 * ProductReviewService is a service class that provides methods to manage product reviews.
 */
@Service
public class ProductReviewService {

	@Autowired
	private ProductReviewsDao productReviewsDao;

	@Autowired
	private ProductService productService;

	/**
	 * Adds a new review for a product.
	 *
	 * @param review The review to be added.
	 * @param id     The ID of the product.
	 * @return The added review.
	 */
	public ProductReview addReviews(ProductReview review, int id) {
		Product p = productService.getProductById(id);
		p.getReview().add(review);

		review.setProduct(p);
		productReviewsDao.save(review);

		return review;
	}

	/**
	 * Retrieves all product reviews.
	 *
	 * @return A list of all product reviews.
	 */
	public List<ProductReview> getReview() {
		List<ProductReview> list = (List<ProductReview>) this.productReviewsDao.findAll();
		return list;
	}

	/**
	 * Updates the state of a product review.
	 *
	 * @param state The new state value.
	 * @param id    The ID of the review.
	 */
	public void updateState(String state, int id) {
		ProductReview review = productReviewsDao.getOne(id);
		review.setState(state);
		productReviewsDao.save(review);
	}

	/**
	 * Gets the total number of product reviews.
	 *
	 * @return The total number of product reviews.
	 */
	public Long getNoOfReviews() {
		return this.productReviewsDao.count();
	}
}
