package org.Store.stationary_store.Service;

import org.Store.stationary_store.Entity.Category;
import org.Store.stationary_store.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    @Autowired
    CategoryRepository categoryRepository;


    public Category setCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategory(int id) {
        return categoryRepository.findById(id).orElseThrow(null);
    }

    public Category updateCategory(int id, Category category) {
        Category refined=categoryRepository.findById(id).orElse(null);
        refined.setCat_id(category.getCat_id());
        refined.setCat_name(category.getCat_name());
        return refined;
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> getAllcategory() {
        return categoryRepository.findAll();
    }
}
