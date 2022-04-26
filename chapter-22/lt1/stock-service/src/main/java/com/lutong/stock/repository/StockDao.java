package com.lutong.stock.repository;

import com.lutong.stock.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lutong
 */
public interface StockDao extends JpaRepository<Stock,String> {
    //根据商品编号查询此商品的库存数量
    //JPA的使用规则：可以通过表字段直接查

     public Stock  findByCommodityCode(String commodityCode);

}
