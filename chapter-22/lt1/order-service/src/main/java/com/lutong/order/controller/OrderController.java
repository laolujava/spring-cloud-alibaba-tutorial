package com.lutong.order.controller;

import com.lutong.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author lutong
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/create")
    public String create(String userId, String commodityCode, Integer count, BigDecimal price) {
        orderService.createOrder(userId,commodityCode,count,price);
        return "ok";
    }
}
