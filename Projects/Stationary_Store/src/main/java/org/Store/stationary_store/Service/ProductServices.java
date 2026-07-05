package org.Store.stationary_store.Service;

import org.Store.stationary_store.Entity.Products;
import org.Store.stationary_store.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServices {

    @Autowired
    ProductRepository productRepository;
    public List<Products> getAllProduct() {
        return productRepository.findAll();
    }


    public Products setProducts(Products product) {
        return productRepository.save(product);
    }

    public Products updateProducts(Integer id, Products product) {
        Products existingproduct=productRepository.findById(id).orElse(null);
        existingproduct.setCategory(existingproduct.getCategory());
        existingproduct.setName(product.getName());
        existingproduct.setPrice(product.getPrice());

        return productRepository.save(existingproduct);
    }
    public void deleteProduct(Integer id){
         productRepository.deleteById(id);
    }

    public List<Products> getProductbyCategory(int categoryId) {
        return productRepository.findByCategory(categoryId);
    }
}
