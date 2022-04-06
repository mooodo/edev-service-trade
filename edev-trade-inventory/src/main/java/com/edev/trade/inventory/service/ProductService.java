package com.edev.trade.inventory.service;

import com.edev.trade.inventory.entity.Product;
import com.edev.trade.inventory.service.hystrix.ProductServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;

@Service
@FeignClient(value = "service-product", fallback = ProductServiceImpl.class)
public interface ProductService {
    @GetMapping("orm/product/getProduct")
    Product getProduct(Long id);
    @PostMapping("list/product/listProducts")
    Collection<Product> listProducts(List<Long> ids);
}
