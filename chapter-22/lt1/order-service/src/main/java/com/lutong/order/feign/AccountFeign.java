package com.lutong.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author lutong
 */
@FeignClient(name="account-service")
public interface AccountFeign {

    @GetMapping("/debit")
    String debit(@RequestParam("userId") String userId,@RequestParam("money") BigDecimal money);
}
