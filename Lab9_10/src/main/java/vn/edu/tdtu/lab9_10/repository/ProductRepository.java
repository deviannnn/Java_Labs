package vn.edu.tdtu.lab9_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.tdtu.lab9_10.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
