package org.example.spring_web_1.Controller;

import org.example.spring_web_1.Entity.Product;
import org.example.spring_web_1.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductServices productServices;
    @RequestMapping("/product")
    public List<Product> getproducts(){
        return productServices.getProduct();
//        this calls the method we introduced in the services layer
    }
    @RequestMapping("/product/{prodId}")
    public Product getProductsbyId(@PathVariable int prodId){
        return productServices.getProductById(prodId);
    }


    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product){

        System.out.println(product);

        return productServices.addProduct(product);
    }

    @PutMapping("/product")
    public void updateProduct(@RequestBody Product product){
        System.out.println(product);

         productServices.updateProduct(product);
    }

    @DeleteMapping("/product/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        System.out.println("started deleting ");
        productServices.deleteProduct(prodId);
    }

}
