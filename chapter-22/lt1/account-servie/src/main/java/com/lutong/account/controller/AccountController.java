package com.lutong.account.controller;

import com.lutong.account.service.AccoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author lutong
 */
@RestController
public class AccountController {
    @Autowired
    private AccoutService accoutService;
    @GetMapping("/debit")
    public String debit(String userId, BigDecimal money) {
        accoutService.debit(userId, money);
        return "ok";
    }

}
