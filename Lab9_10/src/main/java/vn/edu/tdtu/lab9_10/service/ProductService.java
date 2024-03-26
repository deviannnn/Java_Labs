package vn.edu.tdtu.lab9_10.service;

import vn.edu.tdtu.lab9_10.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> listAll();
    Product getById(int id);
    Product save(Product product);
    boolean delete(int id);
    Product update(int id, Product product);
    Product partialUpdate(int id, Map<String, Object> updates);

}
