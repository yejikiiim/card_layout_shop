/*
 * This file is generated by jOOQ.
 */
package com.yeji.h2.entity;


import com.yeji.h2.entity.tables.TbProductMaster;
import com.yeji.h2.entity.tables.TbProductModifyHist;
import com.yeji.h2.entity.tables.TbProductTrade;


/**
 * Convenience access to all tables in the default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * 상품정보 메인 테이블
     */
    public static final TbProductMaster TB_PRODUCT_MASTER = TbProductMaster.TB_PRODUCT_MASTER;

    /**
     * 상품정보 수정 히스토리 테이블
     */
    public static final TbProductModifyHist TB_PRODUCT_MODIFY_HIST = TbProductModifyHist.TB_PRODUCT_MODIFY_HIST;

    /**
     * 상품 주문정보 테이블
     */
    public static final TbProductTrade TB_PRODUCT_TRADE = TbProductTrade.TB_PRODUCT_TRADE;
}