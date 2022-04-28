package com.lutong.order.service;

import com.lutong.order.entity.Order;
import com.lutong.order.feign.AccountFeign;
import com.lutong.order.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author lutong
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountFeign accountFeign;
    //创建订单

    //1、订单表插入一条订单记录
    //2、用户表中余额扣减
    public void createOrder(String userId, String commodityCode, Integer count, BigDecimal price) {
        Order order=new Order();
        order.setCommodityCode(commodityCode);
        order.setUserId(userId);
        order.setCount(new BigDecimal(count));
        //订单金额=单价*数量
        BigDecimal money=price.multiply(new BigDecimal(count));
        order.setMoney(money);

        orderDao.save(order);

        accountFeign.debit(userId, money);

    }


}
