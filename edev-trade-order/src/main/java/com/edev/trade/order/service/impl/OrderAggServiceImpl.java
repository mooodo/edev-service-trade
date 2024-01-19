package com.edev.trade.order.service.impl;

import com.edev.support.event.DomainEventPublisher;
import com.edev.trade.order.entity.Order;
import com.edev.trade.order.service.OrderService;
import com.edev.trade.order.service.OrderAggService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderAgg")
@Slf4j
public class OrderAggServiceImpl implements OrderAggService {
    @Autowired
    private OrderService orderService;
    @Autowired @Qualifier("placeOrderEvent")
    private DomainEventPublisher placeOrderEvent;
    @Autowired @Qualifier("returnGoodsEvent")
    private DomainEventPublisher returnGoodsEvent;
    @Override
    @Transactional
    public Long placeOrder(@NonNull Order order) {
        Long orderId = orderService.create(order);
        log.debug(String.format("create an order: [orderId: %d]", orderId));
        placeOrderEvent.publish("TradeService", order);
        return orderId;
    }
    @Override
    @Transactional
    public void returnGoods(@NonNull Long orderId) {
        Order order = orderService.load(orderId);
        orderService.delete(orderId);
        log.debug(String.format("return the goods: [orderId: %d]", orderId));
        returnGoodsEvent.publish("TradeService", order);
    }
}
