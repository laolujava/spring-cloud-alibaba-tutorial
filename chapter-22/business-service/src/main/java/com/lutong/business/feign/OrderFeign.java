package com.lutong.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author lutong
 */
@FeignClient(name="order-service")
public interface OrderFeign {
    @GetMapping("/create")
    public String create(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode,
                         @RequestParam("count") Integer count,@RequestParam("price") BigDecimal price);
}
