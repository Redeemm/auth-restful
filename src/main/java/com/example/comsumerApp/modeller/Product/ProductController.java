package com.example.comsumerApp.modeller.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getProduct () {
        return productService.getProduct();
    }

    @PostMapping()
    public void registerNewProduct (@RequestBody Product product) {
        productService.addNewProduct(product);
    }

    @DeleteMapping(path = "id")
    public void deleteProduct(@PathVariable("id") Long productID) {
        productService.deleteProduct(productID);
    }
}
