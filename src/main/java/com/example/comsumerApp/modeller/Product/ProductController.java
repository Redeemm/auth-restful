package com.example.comsumerApp.modeller.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> getPartner() {
        return productService.getPartner();
    }

    @PostMapping("create")
    public void registerNewPartner(@RequestBody Product product) {
        productService.addNewPartner(product);
    }

    @DeleteMapping(path = "delete/{Id}")
    public void deletePartner(@PathVariable("Id") Long partnerID) {
        productService.deleteProduct(partnerID);
    }

}
