package org.example.workers_backend_services.Service;

import org.example.workers_backend_services.DTO.CategoryResponseDTO;
import org.example.workers_backend_services.DTO.ReviewResponseDTO;
import org.example.workers_backend_services.Entity.Category;
import org.example.workers_backend_services.Entity.Reviews;
import org.example.workers_backend_services.Repository.Reviews_Request_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class Review_Services {

    @Autowired
    private Reviews_Request_Repository reviewRepository;

    // 1. Create a new review
    public Reviews createReview(Reviews review) {
        // Set the timestamp automatically before saving
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    // 2. Get all reviews
    public List<Reviews> getAllReviews() {
        return reviewRepository.findAll();
    }

    // 3. Get a specific review by ID
    public Optional<Reviews> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    // 4. Update an existing review
    public Optional<Reviews> updateReview(Long id, Reviews reviewDetails) {
        return reviewRepository.findById(id).map(existingReview -> {
            // Update only the modifiable fields
            if (reviewDetails.getRating() != null) {
                existingReview.setRating(reviewDetails.getRating());
            }
            if (reviewDetails.getReviewText() != null) {
                existingReview.setReviewText(reviewDetails.getReviewText());
            }

            // Note: We don't update the reviewId, createdAt, or relationships here
            // to prevent accidental data corruption

            return reviewRepository.save(existingReview);
        });
    }

    // 5. Delete a review
    public boolean deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private ReviewResponseDTO convertToDTO(Reviews reviews){
        return new ReviewResponseDTO(
                reviews.getReviewId(),
                reviews.getCustomer().getUser_name(),
                reviews.getWorker().getUsers().getUser_name(),
                reviews.getServiceRequest().getService_id(),
                reviews.getRating(),
                reviews.getReviewText(),
                reviews.getCreatedAt()
        );
    }
}