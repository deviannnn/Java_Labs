package vn.edu.tdtu.javatech.Lab10.service;


import vn.edu.tdtu.javatech.Lab10.model.Order;

public interface OrderService {
    Iterable<Order> getAllOrders();

    Order create(Order order);

    void update(Order order);

    Order getOrder(Long id);

    void removeById(Long id);
}