package vn.edu.tdtu.lab9_10.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_number")
    private int orderNumber;
    @Column(name = "total_sell")
    private int totalSell;
    @OneToMany(mappedBy = "order")
    private List<OrdersProduct> ordersProducts;
}
