package com.lutong.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author lutong
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableFeignClients
public class OrderAppliction {
    public static void main(String[] args) {
        SpringApplication.run(OrderAppliction.class, args);
    }
}
