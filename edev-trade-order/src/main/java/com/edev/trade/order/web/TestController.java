package com.edev.trade.order.web;

import com.edev.trade.order.entity.Customer;
import com.edev.trade.order.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private CustomerService service;
    @GetMapping("loadCustomer")
    public Customer loadCustomer(Long id) {
        return service.load(id);
    }
}
