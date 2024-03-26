package vn.edu.tdtu.javatech.Lab10.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.tdtu.javatech.Lab10.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> { }