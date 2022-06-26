package com.example.comsumerApp.modeller.Product;

import com.example.comsumerApp.modeller.Partner.Partner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public void addNewProduct(Product product) {
        Optional<Product> productOptional = productRepository.findByProductID(product.getProductID());
        if (productOptional.isPresent()){
            throw new IllegalStateException("name exist!");
        }
        productRepository.save(product);
    }

    public void  deleteProduct(Long productID) {
        productRepository.deleteById(productID);
    }
}
