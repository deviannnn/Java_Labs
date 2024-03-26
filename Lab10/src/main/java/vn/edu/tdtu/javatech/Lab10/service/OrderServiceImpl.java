package vn.edu.tdtu.javatech.Lab10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.tdtu.javatech.Lab10.repository.OrderRepository;
import vn.edu.tdtu.javatech.Lab10.model.Order;

import java.time.LocalDate;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }

    @Override
    public Order getOrder(Long id) {
        return this.orderRepository.findById(id).get();
    }

    @Override
    public void removeById(Long id) {
        this.orderRepository.deleteById(id);
    }


}