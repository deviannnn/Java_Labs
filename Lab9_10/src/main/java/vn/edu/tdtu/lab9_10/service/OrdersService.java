package vn.edu.tdtu.lab9_10.service;

import vn.edu.tdtu.lab9_10.model.Orders;

import java.util.List;

public interface OrdersService {
    List<Orders> listAll();
    Orders getById(int id);
    Orders save(Orders orders);
    Orders update(int id, Orders orders);
    boolean delete(int id);
}
