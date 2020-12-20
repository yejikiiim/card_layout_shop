package com.yeji.api.shoppingmall.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yeji.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ShoppingMallControllerTest extends BaseTest {

    public ShoppingMallControllerTest(ObjectMapper mapper, WebApplicationContext ctx) {
        super(mapper, ctx);
    }

    @Test
    @DisplayName("상품 리스트 조회")
    void getProductList() throws Exception {
        Integer offset = 0;
        mockMvc.perform(get("/list/"+offset))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(100))
                .andDo(print());
    }

    @Test
    @DisplayName("상품 구매")
    void buyProduct() throws Exception {
        Integer id = 1;

        mockMvc.perform(patch("/buy/"+id)
                .param("amount","5")
                .param("customerName", "김예지")
                .param("customerPhoneNum", "01012345678")
                .param("totalPrice", "50000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(100))
                .andDo(print());
    }

    @Test
    @DisplayName("상품 삭제")
    void deleteProduct() throws Exception {
        String groupCode = "UPTSHRT";

        mockMvc.perform(put("/delete/"+groupCode))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(100))
                .andDo(print());
    }


}