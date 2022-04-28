package com.lutong.business.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lutong
 */
@FeignClient(name="stock-service")
public interface StockFeign {
    @GetMapping("/deduct")
    public String deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);
}
