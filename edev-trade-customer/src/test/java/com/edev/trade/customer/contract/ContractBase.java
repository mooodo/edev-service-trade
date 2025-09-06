/*
 * Created by 2020-05-03 20:35:13 
 */
package com.edev.trade.customer.contract;

import com.edev.support.web.OrmController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author fangang
 */
@SpringBootTest
public class ContractBase {
	@Autowired
	private OrmController controller;
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(controller);
	}
}
