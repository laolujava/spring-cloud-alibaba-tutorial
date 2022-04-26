package com.lutong.order.repository;

import com.lutong.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lutong
 */
public interface OrderDao extends JpaRepository<Order, Long> {
}
