package com.edev.trade.customer.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountLogsMvcTest {
    @Autowired
    private MockMvc mvc;

    /**
     * 业务需求：
     * 1）添加账户流水时，不输入主键，实现自增主键，返回自增的主键值
     * 2）根据主键值删除账户流水
     * 说明：在数据库中该表应该选择自增主键，并且主键名必须为id
     */
    @Test
    void test() throws Exception {
        String json = "{\"accountId\":10001,\"amount\":10.0,\"operation\":\"TopUp\"}";
        MvcResult result = mvc.perform(post("/orm/accountLogs/addAccountLogs")
                .content(json).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andReturn();
        String id = result.getResponse().getContentAsString();
        mvc.perform(get("/orm/accountLogs/removeAccountLogs")
                .param("id", id)
        ).andExpect(status().isOk());
    }
}
