package com.lutong.business.service;

import com.lutong.business.feign.OrderFeign;
import com.lutong.business.feign.StockFeign;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author lutong
 */
@Service
public class BusinessService {
    @Autowired
    private StockFeign  stockFeign;
    @Autowired
    private OrderFeign orderFeign;
    @GlobalTransactional
    public void buy(String userId, String commodityCode, Integer count, BigDecimal price) {
        //1、创建订单
        //2、扣减库存
        orderFeign.create(userId, commodityCode, count, price);
        stockFeign.deduct(commodityCode, count);
    }

}
