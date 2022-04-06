package com.edev.trade.inventory.event;

import com.edev.support.event.DomainEventObject;
import com.edev.support.event.DomainEventReceiver;
import com.edev.trade.inventory.entity.Order;
import com.edev.trade.inventory.entity.OrderItem;
import com.edev.trade.inventory.service.InventoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableBinding(CreateOrderEventClient.class)
public class CreateOrderEventReceiver implements DomainEventReceiver {
    private final static Log log = LogFactory.getLog(CreateOrderEventReceiver.class);
    @Autowired
    private InventoryService service;
    @Override
    @StreamListener("createOrder")
    public void apply(DomainEventObject event) {
        Order order = event.convertToEntity(Order.class);
        List<OrderItem> items = order.getOrderItems();
        if(items==null|| items.isEmpty()) return;
        items.forEach(orderItem -> {
            Long balance = service.stockOut(orderItem.getProductId(), orderItem.getQuantity());
            log.debug("stock out for order: [productId:"+orderItem.getProductId()+
                    ",quantity:"+orderItem.getQuantity()+",balance:"+balance+"]");
        });
    }
}
