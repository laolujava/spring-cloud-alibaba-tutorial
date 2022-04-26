package com.lutong.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import jdk.nashorn.internal.ir.ReturnNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lutong
 */
@RestController
public class UserController {
    @SentinelResource(value = "get",blockHandler = "exGet")
    @GetMapping("/get")
    public String get() {
        return "test sentinel";
    }

    public String exGet(BlockException blockException) {
        return "被限流了";
    }
    @SentinelResource(value = "ex" ,fallback = "fb")
    @GetMapping("/ex")
    public String ex() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "熔断测试";
    }

    public String fb() {
        return "被熔断了";
    }

}
