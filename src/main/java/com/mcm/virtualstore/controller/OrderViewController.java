package com.mcm.virtualstore.controller;

import com.mcm.virtualstore.enums.OrderStatus;
import com.mcm.virtualstore.model.Order;
import com.mcm.virtualstore.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("orders", orders);
        model.addAttribute("statuses", OrderStatus.values());
        return "orders";                                    //returns thymeleaf template 'orders.html'
    }

    @PostMapping("/orders")
    public String createOrder(@RequestParam String customerName){
        orderService.createOrder(customerName);
        return "redirect:/";        //redirects back to '/' (refresh page)
    }
    @PostMapping("/orders/{id}/status")
    public String updateOrderStatus(@PathVariable Long id, @RequestParam OrderStatus orderStatus){
        orderService.updateOrderStatus(id, orderStatus);
        return "redirect:/";        //redirects back to '/' (refresh page)
    }

    @PostMapping("/orders/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "redirect:/";        //redirects back to '/' (refresh page)
    }


}
