package sn.usher21.helloapp.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sn.usher21.helloapp.models.Product;
import sn.usher21.helloapp.services.ProductServiceImpl;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/products")
public class ProductController {

    ProductServiceImpl productServiceImpl;
    
    @GetMapping("")
    public List<Product> allProducts() {
        return this.productServiceImpl.getProducts();
    }

    @PostMapping("")
    public Product saveProduct(@RequestBody Product product) {
        return this.productServiceImpl.saveProduct(product);
    }
}
