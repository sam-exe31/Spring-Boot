package org.Store.stationary_store.Controller;

import org.Store.stationary_store.Entity.Products;
import org.Store.stationary_store.Service.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/products")

public class ProductController {

    @Autowired
    private ProductServices services;

    @GetMapping
    public List<Products> getProducts(){
        return  services.getAllProduct();
    }

    @GetMapping("/Category/{cat_id}")
    public List<Products> getBycategory(@PathVariable("cat_id") int category_id){
        return services.getProductbyCategory(category_id);
    }

    @PostMapping("/{id}")
    public Products setProducts(@RequestBody  Products product){
        return services.setProducts(product);
    }
    @PutMapping
    public Products updateProducts(@PathVariable Integer id,@RequestBody Products product){
        return services.updateProducts(id,product);
    }
    @DeleteMapping("/{id}")
    public void deleteProducts(@PathVariable Integer id){
        services.deleteProduct(id);
    }

}
