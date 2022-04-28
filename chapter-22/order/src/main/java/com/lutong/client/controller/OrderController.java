package com.lutong.client.controller;

import com.lutong.client.feign.ProductFeign;
import com.lutong.client.util.HttpClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lutong
 */
@RestController
@RefreshScope
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductFeign productFeign;

    @Value("${name}")
    private String name;

    //显示订单信息 （订单+商品构成）
    @GetMapping("/getOrder")
    public String getOrder() {
        String productInfo = HttpClientUtils.doGet("http://127.0.0.1:8023/getProduct");
        return "订单编号8010，订单包含商品:" + productInfo;
    }

    @GetMapping("/getOrderByRestTemplate")
    public String getOrderByRestTemplate() {
        //http://微服务名称/接口名称
        String res = restTemplate.getForObject("http://product/getProduct", String.class);
        return "订单编号8010，订单包含商品:" + res;
    }

    @GetMapping("/getOrderByFeign")
    public String getOrderByFeign() {
        String product = productFeign.getProduct();
        return "订单编号8010，订单包含商品:" + product;
    }

    //演示配置中心的使用
    @GetMapping("/showConfig")
    public String showConfig() {
        return name;
    }
}
