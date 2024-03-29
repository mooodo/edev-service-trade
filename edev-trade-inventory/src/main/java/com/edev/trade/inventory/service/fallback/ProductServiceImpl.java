package com.edev.trade.inventory.service.fallback;

import com.edev.trade.inventory.entity.Product;
import com.edev.trade.inventory.service.ProductService;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getProduct(Long id) {
        return new Product(id,"Unknown",null,null,null,null);
    }

    @Override
    public Collection<Product> listProducts(@NonNull List<Long> ids) {
        List<Product> list = new ArrayList<>();
        ids.forEach(id->list.add(getProduct(id)));
        return list;
    }
}
