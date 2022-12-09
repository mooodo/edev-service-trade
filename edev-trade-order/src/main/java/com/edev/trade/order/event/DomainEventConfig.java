package com.edev.trade.order.event;

import com.edev.support.event.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding({PlaceOrderEvent.class, ReturnGoodsEvent.class})
public class DomainEventConfig {
    @Autowired
    private PlaceOrderEvent placeOrderEvent;
    @Bean
    public DomainEventPublisher placeOrderEvent() {
        return new DomainEventPublisher("placeOrder", placeOrderEvent);
    }
    @Autowired
    private ReturnGoodsEvent returnGoodsEvent;
    @Bean
    public DomainEventPublisher returnGoodsEvent() {
        return new DomainEventPublisher("returnGoods", returnGoodsEvent);
    }
}
