package org.example.workers_backend_services.Controller;

import jakarta.validation.Valid;
import org.example.workers_backend_services.DTO.CategoryRequestDTO;
import org.example.workers_backend_services.DTO.CategoryResponseDTO;
import org.example.workers_backend_services.Entity.Category;
import org.example.workers_backend_services.Service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Categories")
public class CategoryController {

    @Autowired
    CategoryServices categoryServices;
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory_byid(@PathVariable Long id){
        Category cat=categoryServices.getCategory(id);
        if(cat!=null){
            return ResponseEntity.ok(cat);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> res=categoryServices.getAllcategory();
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> setCategory(@Valid  @RequestBody CategoryRequestDTO dto){
        return ResponseEntity.ok(categoryServices.setCategory(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> putCategory( @PathVariable  Long id,@RequestBody Category category){
        Category category1=categoryServices.updateCategory(id,category);
        if(category1!=null){
            return ResponseEntity.ok(category1);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMapping(@PathVariable Long id){
         categoryServices.deleteCategory(id);
         return ResponseEntity.ok(("Category Deleted"));
    }
 }
