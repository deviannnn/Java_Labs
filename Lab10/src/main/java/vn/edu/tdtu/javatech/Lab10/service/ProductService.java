package vn.edu.tdtu.javatech.Lab10.service;


import vn.edu.tdtu.javatech.Lab10.model.Product;

public interface ProductService {
    Iterable<Product> getAllProducts();

    Product getProduct(long id) throws Exception;

    Product save(Product product);

    void removeById(Long id);
}