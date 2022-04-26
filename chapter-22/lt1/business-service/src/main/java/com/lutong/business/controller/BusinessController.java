package com.lutong.business.controller;

import com.lutong.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author lutong
 */
@RestController
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @GetMapping("/buy")
    public String buy(String userId, String commodityCode, Integer count, BigDecimal price) {
        businessService.buy(userId,commodityCode,count,price);
        return "ok";
    }
}
