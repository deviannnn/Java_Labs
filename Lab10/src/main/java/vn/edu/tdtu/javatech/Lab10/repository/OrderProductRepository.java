package vn.edu.tdtu.javatech.Lab10.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.tdtu.javatech.Lab10.model.OrderProduct;
import vn.edu.tdtu.javatech.Lab10.model.OrderProductPK;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
}