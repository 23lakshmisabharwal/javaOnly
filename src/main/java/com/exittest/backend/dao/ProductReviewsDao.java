package com.exittest.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exittest.backend.model.ProductReview;

@Repository
/**
 * @author aryanverma
 * ProductReviewsDao is a repository interface for performing CRUD operations on ProductReview entities.
 */
public interface ProductReviewsDao extends JpaRepository<ProductReview, Integer> {

}
