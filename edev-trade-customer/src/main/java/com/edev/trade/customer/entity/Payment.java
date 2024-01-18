package com.edev.trade.customer.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Payment extends Entity<Long> {
    private Long id;
    private Long accountId;
    private Double amount;
    private String status;
}
