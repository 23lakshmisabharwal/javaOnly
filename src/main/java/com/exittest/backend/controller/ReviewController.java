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

import com.exittest.backend.model.ProductReview;
import com.exittest.backend.service.ProductReviewService;

/**
 * @author aryanverma
 * Controller class for handling product review operations.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ReviewController {
	
	@Autowired
	private ProductReviewService productReviewService;
	/**
	 * Adds a review for a product.
	 *
	 * @param review The review to add.
	 * @param id The ID of the product to add the review for.
	 * @return The response entity indicating the success of the operation.
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping("/add-reviews/{id}")
	public ResponseEntity addReview(@RequestBody ProductReview review, @PathVariable("id") int id) {

		productReviewService.addReviews(review, id);

		return ResponseEntity.status(200).build();
	}
	/**
	 * Retrieves all product reviews (for admin use).
	 *
	 * @return The response entity containing the list of all product reviews or a no content status if there are no reviews.
	 */
	@GetMapping("/admin/all-reviews")
	public ResponseEntity<List<ProductReview>> getReviews() {

		List<ProductReview> list = this.productReviewService.getReview();
		if (list.size() == 0)
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(list);
	}
	/**
	 * Updates the state of a product review (for admin use).
	 *
	 * @param state The new state of the review.
	 * @param id    The ID of the review to update.
	 * @return The response entity indicating the success of the operation.
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping("/admin/update/{id}/{state}")
	public ResponseEntity updateReview(@PathVariable("state") String state, @PathVariable("id") int id) {
		productReviewService.updateState(state, id);
		return ResponseEntity.status(200).build();
	}
	/**
	 * Retrieves the number of product reviews.
	 *
	 * @return The number of product reviews.
	 */
	@GetMapping("/count-reviews")
	public Long getNumberOfReviews()
	{
		return this.productReviewService.getNoOfReviews();
	}

}
