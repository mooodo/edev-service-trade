package com.edev.trade.order.event;

import com.edev.support.event.DomainEventOutput;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ReturnGoodsEvent extends DomainEventOutput {
    @Override
    @Output("returnGoods")
    MessageChannel output();
}
