package com.mcm.virtualstore.controller;

import com.mcm.virtualstore.enums.OrderStatus;
import com.mcm.virtualstore.model.Order;
import com.mcm.virtualstore.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller                                     //spring mvc controller for handling Thymeleaf req (not API req)
@RequestMapping("/")                         //base url for all methods
public class OrderViewController {
    private final OrderService orderService;    //serv injected so controller can interact with others

    public OrderViewController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping                                             //home page
    public String viewOrders(Model model){
        List<Order> orders = orderService.getAllOrders();   //fetch all orders
        model.addAttribute("orders");
        model.addAttribute("statuses", OrderStatus.values());
        return "orders";                                    //returns thymeleaf template 'orders.html'
    }


}
