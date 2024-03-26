package vn.edu.tdtu.javatech.Lab10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.edu.tdtu.javatech.Lab10.model.Product;


import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
}