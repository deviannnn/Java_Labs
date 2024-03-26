package vn.edu.tdtu.repository;

import vn.edu.tdtu.model.Product;

import java.util.List;

public interface ProductRepository {
    void insert(Product item);
    List<Product> readAll();
    void delete(int id);
}
