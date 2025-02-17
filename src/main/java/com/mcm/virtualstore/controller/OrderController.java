package com.mcm.virtualstore.controller;

import com.mcm.virtualstore.model.Order;
import com.mcm.virtualstore.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController                 //marks class as RESTful API controller
@RequestMapping("/orders")   //sets base URL
public class OrderController {
    private final OrderService orderService;        // DI dependency injected in the constructor

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    //injects service automatically when controller is created
    //best practice: ctor-based injection ensures immutability

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();     //calls the service which returns a List of all orders from db
    }

    @GetMapping("/{id}")        // extracts 'id' from the url path (base url '/orders' + '/{id}')
    public ResponseEntity<Order> getOrderById(@PathVariable Long _id) {
        Optional<Order> orderById = orderService.getOrderById(_id);
        return orderById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
