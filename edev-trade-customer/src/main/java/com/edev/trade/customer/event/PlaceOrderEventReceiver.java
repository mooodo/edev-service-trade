package com.edev.trade.customer.event;

import com.edev.support.event.DomainEventObject;
import com.edev.support.event.DomainEventReceiver;
import com.edev.support.exception.ValidException;
import com.edev.trade.customer.entity.Order;
import com.edev.trade.customer.entity.Payment;
import com.edev.trade.customer.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(PlaceOrderEventClient.class)
@Slf4j
public class PlaceOrderEventReceiver implements DomainEventReceiver {
    @Autowired
    private AccountService paymentService;
    @Override
    @StreamListener("placeOrder")
    public void apply(DomainEventObject event) {
        Order order = event.convertToEntity(Order.class);
        if(order==null||order.getPayment()==null)
            throw new ValidException("Didn't get the order and its payment");
        Payment payment = order.getPayment();
        Double balance = paymentService.payoff(payment.getAccountId(), payment.getAmount());
        log.debug(String.format("pay off for the order: [orderId:%d,accountId:%d,amount:%f,balance:%f]",
                order.getId(),payment.getAccountId(),payment.getAmount(),balance));
    }
}
