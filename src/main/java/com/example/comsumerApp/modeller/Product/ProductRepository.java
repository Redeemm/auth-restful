package com.example.comsumerApp.modeller.Product;

import com.example.comsumerApp.modeller.Partner.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository <Product, Long> {
    @Query("SELECT s FROM Product s WHERE s.ProductID = ?1")
    Optional<Product> findByProductID(Long productID);

}
