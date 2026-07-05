package org.example.workers_backend_services.Service;

import jakarta.persistence.Entity;
import org.example.workers_backend_services.Entity.Category;
import org.example.workers_backend_services.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {

    @Autowired
    CategoryRepository categoryRepository;
//    @Autowired
//    private Category category;


    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(null);
    }

    public List<Category> getAllcategory() {
        return categoryRepository.findAll();
    }

    public Category setCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category category) {
        Category refined=categoryRepository.findById(id).orElseThrow(null);
        refined.setCat_name(category.getCat_name());
        refined.setDescription(category.getDescription());
        System.out.println(category.getCat_name());
        System.out.println(category.getDescription());
        return categoryRepository.save(refined);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
