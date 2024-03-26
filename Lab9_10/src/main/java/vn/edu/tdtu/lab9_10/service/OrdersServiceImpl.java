package vn.edu.tdtu.lab9_10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.tdtu.lab9_10.model.Orders;
import vn.edu.tdtu.lab9_10.repository.OrdersRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<Orders> listAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders getById(int id) {
        Optional<Orders> result = ordersRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders update(int id, Orders orders) {
        Optional<Orders> result = ordersRepository.findById(id);
        if (result.isPresent()) {
            Orders existingOrders = result.get();
            existingOrders.setOrderNumber(orders.getOrderNumber());
            existingOrders.setTotalSell(orders.getTotalSell());
            existingOrders.setOrdersProducts(orders.getOrdersProducts());
            return ordersRepository.save(existingOrders);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        Optional<Orders> result = ordersRepository.findById(id);
        if (result.isPresent()) {
            ordersRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}

