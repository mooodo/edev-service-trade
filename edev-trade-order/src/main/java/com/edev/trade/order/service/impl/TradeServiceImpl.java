package com.edev.trade.order.service.impl;

import com.edev.support.event.DomainEventPublisher;
import com.edev.trade.order.entity.Order;
import com.edev.trade.order.service.OrderService;
import com.edev.trade.order.service.TradeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("trade")
public class TradeServiceImpl implements TradeService {
    private final static Log log = LogFactory.getLog(TradeServiceImpl.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    @Qualifier("createOrderEvent")
    private DomainEventPublisher createOrderEvent;
    @Override
    @Transactional
    public Long doTrade(Order order) {
        Long orderId = orderService.create(order);
        log.debug("create an order[orderId: "+orderId+"]");
        createOrderEvent.publish("TradeService", order);
        return orderId;
    }
}
