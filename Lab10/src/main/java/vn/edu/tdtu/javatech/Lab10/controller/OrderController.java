package vn.edu.tdtu.javatech.Lab10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vn.edu.tdtu.javatech.Lab10.dto.OrderDto;
import vn.edu.tdtu.javatech.Lab10.dto.OrderProductDto;
import vn.edu.tdtu.javatech.Lab10.model.Order;
import vn.edu.tdtu.javatech.Lab10.model.OrderProduct;
import vn.edu.tdtu.javatech.Lab10.model.OrderStatus;
import vn.edu.tdtu.javatech.Lab10.model.Product;
import vn.edu.tdtu.javatech.Lab10.service.OrderProductService;
import vn.edu.tdtu.javatech.Lab10.service.OrderService;
import vn.edu.tdtu.javatech.Lab10.service.ProductService;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderProductService orderProductService;

    @GetMapping(value = { "", "/" })
    public @NotNull Iterable<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping(value = {"/{id}"})
    public Order getOrder(@PathVariable Long id) throws Exception {
        return orderService.getOrder(id);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderDto orderDto) throws Exception {
        List<OrderProductDto> formDtos = orderDto.getProductOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();
        for (OrderProductDto dto : formDtos) {
            orderProducts.add(orderProductService.create(new OrderProduct(order, productService.getProduct(dto
                    .getProduct()
                    .getId()), dto.getQuantity())));
        }

        order.setOrderProducts(orderProducts);
        this.orderService.update(order);

        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/orders/{id}")
                .buildAndExpand(order.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(order, headers, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderProductDto> orderProducts) {
        List<OrderProductDto> list = orderProducts
                .stream()
                .filter(op -> {
                    try {
                        return Objects.isNull(productService.getProduct(op
                                .getProduct()
                                .getId()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            new Exception("Product not found");
        }
    }

    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Order> updateProduct(@PathVariable Long id, @RequestBody OrderDto orderDto) throws Exception {
        Order order = orderService.getOrder(id);
        if (orderDto.getStatus() != null) order.setStatus(orderDto.getStatus());
        orderService.update(order);
        return new ResponseEntity(order, HttpStatus.OK);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Product> deleteOrder(@PathVariable Long id) {
        orderService.removeById(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }
}