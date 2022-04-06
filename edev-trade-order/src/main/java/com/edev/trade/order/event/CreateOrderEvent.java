package com.edev.trade.order.event;

import com.edev.support.event.DomainEventOutput;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CreateOrderEvent extends DomainEventOutput {
    @Override
    @Output("createOrder")
    MessageChannel output();
}
