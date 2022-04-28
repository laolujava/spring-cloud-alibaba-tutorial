package com.lutong.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lutong
 */
@FeignClient("product")
public interface ProductFeign {
    @GetMapping("/getProduct")
    public String getProduct();
}
