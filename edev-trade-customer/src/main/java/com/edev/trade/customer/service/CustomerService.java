package com.edev.trade.customer.service;

import com.edev.trade.customer.entity.Address;
import com.edev.trade.customer.entity.Customer;

import java.util.Collection;
import java.util.List;

public interface CustomerService {
    Long register(Customer customer);
    void modify(Customer customer);
    void delete(Long customerId);
    Customer load(Long customerId);
    void saveAll(List<Customer> customers);
    void deleteAll(List<Long> customerIds);
    Collection<Customer> loadAll(List<Long> customerIds);
    Address loadAddress(Long addressId);
    Collection<Address> loadAddresses(List<Long> addressIds);
}