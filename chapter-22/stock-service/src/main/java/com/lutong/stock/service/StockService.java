package com.lutong.stock.service;

import com.lutong.stock.entity.Stock;
import com.lutong.stock.repository.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lutong
 */
@Service
public class StockService {
    @Autowired
    private StockDao stockDao;

    public void deduct(String commodityCode,Integer count) {

        // 10 -1 =9
        // 8 - 2 =6
        //查询出原来的库存数量，减去要扣除的数量
        //根据商品编号查询
        if (commodityCode.equals("m1")) {
            throw new RuntimeException("人为制造的异常");
        }
        Stock stock = stockDao.findByCommodityCode(commodityCode);
        Integer n = stock.getCount() - count;
        stock.setCount(n);
        stockDao.save(stock);
    }
}
