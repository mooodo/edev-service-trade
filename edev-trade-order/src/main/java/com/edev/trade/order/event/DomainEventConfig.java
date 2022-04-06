package com.edev.trade.order.event;

import com.edev.support.event.DomainEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(CreateOrderEvent.class)
public class DomainEventConfig {
    @Autowired
    private CreateOrderEvent createOrderEvent;
    @Bean("createOrderEvent")
    public DomainEventPublisher createOrderEventPublisher() {
        return new DomainEventPublisher("createOrder", createOrderEvent);
    }
}
