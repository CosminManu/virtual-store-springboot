package com.mcm.virtualstore.model;

import com.mcm.virtualstore.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tblOrder")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private LocalDate orderDate;

    public Order() {}

    public Order(String customerName, OrderStatus orderStatus, LocalDate orderDate){
        this.customerName = customerName;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}
