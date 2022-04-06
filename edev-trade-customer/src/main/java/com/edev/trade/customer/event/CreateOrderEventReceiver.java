package com.edev.trade.customer.event;

import com.edev.support.event.DomainEventObject;
import com.edev.support.event.DomainEventReceiver;
import com.edev.trade.customer.entity.Order;
import com.edev.trade.customer.service.AccountService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(CreateOrderEventClient.class)
public class CreateOrderEventReceiver implements DomainEventReceiver {
    private final static Log log = LogFactory.getLog(CreateOrderEventReceiver.class);
    @Autowired
    private AccountService accountService;
    @Override
    @StreamListener("createOrder")
    public void apply(DomainEventObject event) {
        Order order = event.convertToEntity(Order.class);
        Double balance = accountService.payoff(order.getCustomerId(), order.getAmount());
        log.debug("pay off for the order: [customerId:"+order.getCustomerId()+
                ",amount:"+order.getAmount()+",balance:"+balance+"]");
    }
}
