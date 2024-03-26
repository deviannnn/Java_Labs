package vn.edu.tdtu.lab9_10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.tdtu.lab9_10.model.Orders;
import vn.edu.tdtu.lab9_10.service.OrdersService;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Orders>> listAll() {
        List<Orders> ordersList = ordersService.listAll();
        return new ResponseEntity<>(ordersList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Orders> getOrder(@PathVariable("id") int orderId) {
        Orders order = ordersService.getById(orderId);
        if (order != null) {
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders order) {
        Orders newOrder = ordersService.save(order);
        return new ResponseEntity<>(newOrder, HttpStatus.OK);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Orders> updateOrder(@PathVariable("id") int orderId, @RequestBody Orders order) {
        Orders updatedOrder = ordersService.update(orderId, order);
        if (updatedOrder != null) {
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") int orderId) {
        boolean result = ordersService.delete(orderId);
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

