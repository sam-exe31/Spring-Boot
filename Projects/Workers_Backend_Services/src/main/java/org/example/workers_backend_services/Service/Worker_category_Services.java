package org.example.workers_backend_services.Service;

import org.example.workers_backend_services.Entity.Worker_category;
import org.example.workers_backend_services.Repository.Worker_category_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Worker_category_Services {

    @Autowired
    Worker_category_Repository categoryRepository;

    public Worker_category createWorkerCategory(Worker_category category) {
        return categoryRepository.save(category);
    }


    public List<Worker_category> getAllWorkerCategories() {
        return categoryRepository.findAll();
    }


    public Worker_category getWorkerCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }


    public Worker_category updateWorkerCategory(Long id, Worker_category categoryDetails) {
        Optional<Worker_category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            Worker_category existingCategory = optionalCategory.get();
            existingCategory.setMin_price(categoryDetails.getMin_price());
            existingCategory.setMax_price(categoryDetails.getMax_price());
          return categoryRepository.save(existingCategory);
        }
        return null;
    }

    public boolean deleteWorkerCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
