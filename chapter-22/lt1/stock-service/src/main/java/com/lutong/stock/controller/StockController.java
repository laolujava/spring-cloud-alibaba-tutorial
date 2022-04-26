package com.lutong.stock.controller;

import com.lutong.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lutong
 */
@RestController
public class StockController {
    @Autowired
    private StockService stockService;
    @GetMapping("/deduct")
    public String deduct(String commodityCode,Integer count) {
        stockService.deduct(commodityCode, count);
        return "ok";
    }
}
