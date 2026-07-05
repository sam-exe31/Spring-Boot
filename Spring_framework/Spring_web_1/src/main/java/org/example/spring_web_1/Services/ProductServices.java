package org.example.spring_web_1.Services;

import org.example.spring_web_1.Entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductServices {

    public List<Product> product = new ArrayList<>(Arrays.asList(new Product(101,"mobile",5000)
                                ,new Product(102,"cannon camera",70000)));

    public List<Product> getProduct(){
        return product;
    }

    public Product getProductById(int prodId){
        for(Product p:product){
            if(p.getProdId()==prodId){
                return p;
            }
        }
        return null;
//                            return product.stream()
//                                          .filter(p -> p.getId() == prodId)
//                                          .findFirst()
//                                          .orElse(null);
    }

    public Product addProduct(Product products){
         product.add(products);
         return products;
    }


    public void updateProduct(Product producer) {
        int index=0;
        for(int i=0;i<product.size();i++){
            if(product.get(i).getProdId()==producer.getProdId()){
                index =i;
            }
            product.set(index,producer);
        }
    }

    public void deleteProduct(int prodId){
       int index=0;
        // in this logic if product id is not fouund then it will delete the first element which is wrong
        // but here we are only understanding the logic or how to perform things nto more than thatw
       for(int i=0;i<product.size();i++){
           if(product.get(i).getProdId()==prodId){
               index=i;
           }
       }

       product.remove(index);
    }
}
