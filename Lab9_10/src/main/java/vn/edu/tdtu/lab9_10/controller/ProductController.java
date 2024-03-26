package vn.edu.tdtu.lab9_10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.tdtu.lab9_10.model.Product;
import vn.edu.tdtu.lab9_10.service.ProductService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/products")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class ProductController {
    @Autowired
    ProductService productService;

    // Get all products
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Product>> listAll() {
        List<Product> products = productService.listAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // Get a product by id
    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId) {
        Product product = productService.getById(productId);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new product
    @PostMapping(produces = "application/json")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.save(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    // Replace the entire product with new data
    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int productId, @RequestBody Product product) {
        Product updatedProduct = productService.update(productId, product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update some information of a product
    @PatchMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Product> partialUpdateProduct(@PathVariable("id") int productId, @RequestBody Map<String, Object> updates) {
        Product updatedProduct = productService.partialUpdate(productId, updates);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a product by id
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int productId) {
        boolean deleted = productService.delete(productId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

