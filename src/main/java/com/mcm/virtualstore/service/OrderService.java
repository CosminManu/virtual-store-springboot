package com.mcm.virtualstore.service;

import com.mcm.virtualstore.enums.OrderStatus;
import com.mcm.virtualstore.model.Order;
import com.mcm.virtualstore.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;  //DI dependency injection orderRepository declared as final because injected in ctor

    public OrderService(OrderRepository orderRepository) {      //inject OrderRepo auto when service is created
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id_){      //'Optional' helps handle cases where order does not exist - prevent NPE
        Optional<Order> optional = orderRepository.findById(id_);
        if(optional.isPresent()){
            System.out.println("Order with id: " + id_ + " found.");
        } else {
            System.out.println("Order with id: " + id_ + " NOT found!");
        }
        return optional;
    }

    public Order createOrder(String customerName){
        Order order = new Order(customerName, OrderStatus.PLASATA, LocalDate.now());  //client places a command right now
        return orderRepository.save(order);  //save to H2 db and return new order
    }

    public boolean updateOrderStatus(Long id_, OrderStatus status_){
        Optional<Order> optional = orderRepository.findById(id_);
        if(optional.isPresent()){
            Order order = optional.get();
            order.setOrderStatus(status_);
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    public boolean deleteOrder(Long _id) {
        Optional<Order> orderOptional = orderRepository.findById(_id);
        if(orderOptional.isPresent()) {
            orderRepository.deleteById(_id);
            return true;
        }
        return false;
    }
}
