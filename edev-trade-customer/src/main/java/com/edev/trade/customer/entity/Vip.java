package com.edev.trade.customer.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class Vip extends Entity<Long> {
    protected Long id;
    protected Date createTime;
    protected Date updateTime;
    protected String available;
    protected Long coin;
    protected String vipType;
    protected Customer customer;

    public static Vip build() {
        return new Vip();
    }

    public Vip setValues(Long id, Boolean available, Long coin, String vipType) {
        return this.setValues(id, null, null, available, coin, vipType);
    }

    public Vip setValues(Long id, Date createTime, Date updateTime, Boolean available, Long coin, String vipType) {
        this.setId(id);
        this.setCreateTime(createTime);
        this.setUpdateTime(updateTime);
        this.setAvailable(available);
        this.setCoin(coin);
        this.setVipType(vipType);
        return this;
    }

    public Boolean getAvailable() {
        return "Y".equals(available);
    }

    public void setAvailable(Boolean available) {
        this.available = available ? "Y" : "N";
    }

    public Double discount() {
        return 1D;
    }

}
