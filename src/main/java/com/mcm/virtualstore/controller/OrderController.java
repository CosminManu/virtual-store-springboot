package com.mcm.virtualstore.controller;

import com.mcm.virtualstore.enums.OrderStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long _id) {     // extracts 'id' from the url path (base url '/orders' + '/{id}')
        Optional<Order> orderById = orderService.getOrderById(_id);         //Java 8 Optional: if order doesn't exist, return Optional.empty() (avoid NPE)
        return orderById.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //'::' - method reference syntax java 8
    //return orderById.map(order -> ResponseEntity.ok(order)).orElseGet(() -> ResponseEntity.notFound().build())
    //equivalent (explicit lambda expr)

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam String _customerName){   // extracts 'customerName' from query parameters, no body needed
        Order newOrder = orderService.createOrder(_customerName);               //creates and saves the order
        return ResponseEntity.ok(newOrder);             // returns the created order in response
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable Long _id, @RequestParam OrderStatus _status){     //extracts id from url path and status from query params
        boolean updatedOrder = orderService.updateOrderStatus(_id, _status);
        if(updatedOrder){
            return ResponseEntity.ok("Order id:" + _id + " updated successfully with status: "+ _status);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
    // PUT /orders/1/status?status=SHIPPED

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long _id){
        boolean deleteOrder = orderService.deleteOrder(_id);
        if(deleteOrder){
            return ResponseEntity.ok("Order id: " + _id + " deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    // DELETE /orders/1

}
