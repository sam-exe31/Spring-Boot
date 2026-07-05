package org.Store.stationary_store.Controller;

import jakarta.persistence.Entity;
import org.Store.stationary_store.Entity.Category;
import org.Store.stationary_store.Service.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@Controller
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    CategoryServices categoryServices;
    @GetMapping
    public List<Category> getAllCategory(){
        return categoryServices.getAllcategory();
    }
    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id){
        return categoryServices.getCategory(id);
    }

    @PostMapping
    public Category setCategory(@RequestBody  Category category){
        return categoryServices.setCategory(category);
    }


    @PutMapping
    public Category putCategory( @PathVariable  @RequestBody int id,Category category){
        return categoryServices.updateCategory(id,category);
    }
    @DeleteMapping
    public void deleteCategory(@PathVariable  int id){
        categoryServices.deleteCategory(id);
    }
}
