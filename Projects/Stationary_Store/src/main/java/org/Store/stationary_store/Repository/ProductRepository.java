package org.Store.stationary_store.Repository;


import org.Store.stationary_store.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {

    @Query("SELECT p FROM Products p WHERE p.category.cat_id = :id")
     List<Products> findByCategory(@Param("id")int categoryId);
}
