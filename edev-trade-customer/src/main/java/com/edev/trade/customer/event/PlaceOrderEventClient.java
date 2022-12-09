package com.edev.trade.customer.event;

import com.edev.support.event.DomainEventInput;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface PlaceOrderEventClient extends DomainEventInput {
    @Override
    @Input("placeOrder")
    SubscribableChannel input();
}
