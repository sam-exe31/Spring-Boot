package org.example.workers_backend_services.Controller;

import org.example.workers_backend_services.Entity.Reviews;
import org.example.workers_backend_services.Service.Review_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
public class Review_Controller {

    @Autowired
    Review_Services services;

    @PostMapping
    public ResponseEntity<Reviews> createReview(@RequestBody Reviews review) {
        Reviews savedReview = services.createReview(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    // 2. Get all reviews
    @GetMapping
    public ResponseEntity<List<Reviews>> getAllReviews() {
        List<Reviews> reviews = services.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    // 3. Get a specific review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Reviews> getReviewById(@PathVariable Long id) {
        Optional<Reviews> review = services.getReviewById(id);
        return review.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. Update an existing review
    @PutMapping("/{id}")
    public ResponseEntity<Reviews> updateReview(@PathVariable Long id, @RequestBody Reviews reviewDetails) {
        Optional<Reviews> updatedReview = services.updateReview(id, reviewDetails);
        return updatedReview.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 5. Delete a review
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        if (services.deleteReview(id)) {
            return ResponseEntity.noContent().build(); // 204 No Content for successful deletion
        }
        return ResponseEntity.notFound().build(); // 404 Not Found if the ID doesn't exist
    }
}
