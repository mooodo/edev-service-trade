package com.edev.trade.inventory.event;

import com.edev.support.event.DomainEventInput;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CreateOrderEventClient extends DomainEventInput {
    @Override
    @Input("createOrder")
    SubscribableChannel input();
}
