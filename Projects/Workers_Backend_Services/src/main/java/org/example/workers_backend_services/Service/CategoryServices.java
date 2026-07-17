package org.example.workers_backend_services.Service;

import jakarta.persistence.Entity;
import org.example.workers_backend_services.DTO.CategoryRequestDTO;
import org.example.workers_backend_services.DTO.CategoryResponseDTO;
import org.example.workers_backend_services.DTO.UserResponseDTO;
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

    public CategoryResponseDTO setCategory(CategoryRequestDTO dto) {
        Category category1=new Category();
        category1.setCat_name(dto.getCat_name());
        category1.setDescription(dto.getDescription());
        Category saved=categoryRepository.save(category1);
        return convertToDTO(saved);

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


    private CategoryResponseDTO convertToDTO(Category category){
        return new CategoryResponseDTO(
                category.getCat_id(),
                category.getCat_name(),
                category.getDescription()
        );
    }
}
