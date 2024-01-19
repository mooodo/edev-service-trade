package com.edev.trade.inventory.event;

import com.edev.support.ddd.NullEntityException;
import com.edev.support.event.DomainEventObject;
import com.edev.support.event.DomainEventReceiver;
import com.edev.trade.inventory.entity.Order;
import com.edev.trade.inventory.entity.OrderItem;
import com.edev.trade.inventory.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableBinding(PlaceOrderEventClient.class)
@Slf4j
public class PlaceOrderEventReceiver implements DomainEventReceiver {
    @Autowired
    private InventoryService service;
    @Override
    @StreamListener("placeOrder")
    public void apply(DomainEventObject event) {
        Order order = event.convertToEntity(Order.class);
        if(order==null) throw new NullEntityException();
        List<OrderItem> items = order.getOrderItems();
        if(items==null|| items.isEmpty()) return;
        items.forEach(orderItem -> {
            Long balance = service.stockOut(orderItem.getProductId(), orderItem.getQuantity());
            log.debug(String.format("stock out for order: [productId:%d,quantity:%d,balance:%d]",
                    orderItem.getProductId(),orderItem.getQuantity(),balance));
        });
    }
}
