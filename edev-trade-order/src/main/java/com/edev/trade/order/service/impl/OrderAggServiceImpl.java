package com.edev.trade.order.service.impl;

import com.edev.support.ddd.NullEntityException;
import com.edev.support.event.DomainEventPublisher;
import com.edev.support.exception.ValidException;
import com.edev.trade.order.entity.Order;
import com.edev.trade.order.service.OrderService;
import com.edev.trade.order.service.OrderAggService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("orderAgg")
public class OrderAggServiceImpl implements OrderAggService {
    private final static Log log = LogFactory.getLog(OrderAggServiceImpl.class);
    @Autowired
    private OrderService orderService;
    @Autowired @Qualifier("placeOrderEvent")
    private DomainEventPublisher placeOrderEvent;
    @Autowired @Qualifier("returnGoodsEvent")
    private DomainEventPublisher returnGoodsEvent;
    @Override
    @Transactional
    public Long placeOrder(Order order) {
        if (order==null) throw new NullEntityException();
        Long orderId = orderService.create(order);
        log.debug(String.format("create an order: [orderId: %d]", orderId));
        placeOrderEvent.publish("TradeService", order);
        return orderId;
    }
    @Override
    @Transactional
    public void returnGoods(Long orderId) {
        if(orderId==null) throw new ValidException("The order id is null!");
        Order order = orderService.load(orderId);
        orderService.delete(orderId);
        log.debug(String.format("return the goods: [orderId: %d]", orderId));
        returnGoodsEvent.publish("TradeService", order);
    }
}
