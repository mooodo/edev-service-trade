/* 
 * Created by 2018年9月9日
 */
package com.edev.trade.product.entity;

import com.edev.support.entity.Entity;

/**
 * The supplier entity
 * @author fangang
 */
public class Supplier extends Entity<Long> {
	private Long id;
	private String name;
	
	public Supplier() { super(); }
	public Supplier(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	@Override
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	@Override
	public void setId(Long id) {
		this.id = (Long)id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
