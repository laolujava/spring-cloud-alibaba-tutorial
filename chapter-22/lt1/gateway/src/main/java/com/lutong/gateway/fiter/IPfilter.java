package com.lutong.gateway.fiter;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author lutong
 */
@Component
public class IPfilter implements GlobalFilter, Ordered {
    private static final Logger log = LoggerFactory.getLogger(IPfilter.class);
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求的ip、
        String hostName = exchange.getRequest().getHeaders().getHost().getHostName();
        if ("127.0.0.1".equals(hostName)) {
            //如果符合条件，打印字符
            log.info("###############");
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
