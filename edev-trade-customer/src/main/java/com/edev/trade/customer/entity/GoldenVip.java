package com.edev.trade.customer.entity;

import java.util.Date;

public class GoldenVip extends Vip{
    private Double cashback;
    public GoldenVip() { super(); }

    public GoldenVip(Long id, Boolean available, Long coin, Double cashback) {
        super(id, available, coin, "golden");
        this.cashback = cashback;
    }

    public Double getCashback() {
        return cashback;
    }

    public void setCashback(Double cashback) {
        this.cashback = cashback;
    }
}
