package com.lutong.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lutong
 */
@RestController
public class ProductController {
    //获取当前微服务实例的端口号
    @Value("${server.port}")
    private String port;

    @GetMapping("/getProduct")
    public String getProduct() {
        return "显卡1208型号"+",实例端口是："+port;
    }
}
