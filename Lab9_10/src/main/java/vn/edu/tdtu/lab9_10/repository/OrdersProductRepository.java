package vn.edu.tdtu.lab9_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.tdtu.lab9_10.model.OrdersProduct;

public interface OrdersProductRepository extends JpaRepository<OrdersProduct, Integer> {
}
