package vn.edu.tdtu.javatech.Lab10.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.tdtu.javatech.Lab10.dto.ProductDto;
import vn.edu.tdtu.javatech.Lab10.model.Product;
import vn.edu.tdtu.javatech.Lab10.service.ProductService;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) throws Exception {
        Product product = Product.builder()
                .brand(productDto.getBrand())
                .color(productDto.getColor())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping(value = {"/{id}"})
    public Product getProduct(@PathVariable Long id) throws Exception {
        return productService.getProduct(id);
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) throws Exception {
        Product product = productService.getProduct(id);
        if (productDto.getName() != null) product.setName(productDto.getName());
        if (productDto.getPrice() != null) product.setPrice(productDto.getPrice());
        if (productDto.getBrand() != null) product.setBrand(productDto.getBrand());
        if (productDto.getColor() != null) product.setColor(productDto.getColor());
        productService.save(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PatchMapping(value = {"/{id}"})
    public ResponseEntity<Product> modifyProduct(@PathVariable Long id, @RequestBody ProductDto productDto) throws Exception {
        Product product = productService.getProduct(id);
        if (productDto.getName() != null) product.setName(productDto.getName());
        if (productDto.getPrice() != null) product.setPrice(productDto.getPrice());
        if (productDto.getBrand() != null) product.setBrand(productDto.getBrand());
        if (productDto.getColor() != null) product.setColor(productDto.getColor());
        productService.save(product);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        productService.removeById(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }

}