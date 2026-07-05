package org.example.workers_backend_services.Controller;

import org.example.workers_backend_services.Entity.Worker_category;
import org.example.workers_backend_services.Service.Worker_category_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/workercategory")
public class Worker_category_Controller {

    @Autowired
    Worker_category_Services services;

    @PostMapping
    public ResponseEntity<Worker_category> createWorkerCategory(@RequestBody Worker_category category) {
        Worker_category createdCategory = services.createWorkerCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED); // Returns HTTP 201
    }

    // READ (ALL)
    @GetMapping
    public ResponseEntity<List<Worker_category>> getallworkercat() {
        List<Worker_category> categories = services.getAllWorkerCategories();
        return ResponseEntity.ok(categories); // Returns HTTP 200
    }

    // READ (BY ID)
    @GetMapping("/{id}")
    public ResponseEntity<Worker_category> getWorkerCategoryById(@PathVariable Long id) {
        Worker_category category = services.getWorkerCategoryById(id);
        if (category != null) {
            return ResponseEntity.ok(category);
        }
        return ResponseEntity.notFound().build();
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Worker_category> updateWorkerCategory(@PathVariable Long id, @RequestBody Worker_category categoryDetails) {
        Worker_category updatedCategory = services.updateWorkerCategory(id, categoryDetails);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWorkerCategory(@PathVariable Long id) {
        boolean deleted = services.deleteWorkerCategory(id);
        if (deleted) {
            return ResponseEntity.ok("Worker category deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Worker category not found with id: " + id);
    }
}
