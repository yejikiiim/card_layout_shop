/*
 * This file is generated by jOOQ.
 */
package com.yeji.h2.entity.tables.records;


import com.yeji.h2.entity.tables.TbProductTrade;

import java.sql.Timestamp;

import org.jooq.Field;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.TableRecordImpl;


/**
 * 상품 주문정보 테이블
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TbProductTradeRecord extends TableRecordImpl<TbProductTradeRecord> implements Record11<Integer, Integer, Integer, Integer, String, String, Integer, String, Timestamp, String, Timestamp> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>TB_PRODUCT_TRADE.ID</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.ID</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>TB_PRODUCT_TRADE.PRODUCT_MASTER_ID</code>.
     */
    public void setProductMasterId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.PRODUCT_MASTER_ID</code>.
     */
    public Integer getProductMasterId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>TB_PRODUCT_TRADE.AMOUNT</code>.
     */
    public void setAmount(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.AMOUNT</code>.
     */
    public Integer getAmount() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>TB_PRODUCT_TRADE.TOTAL_PRICE</code>.
     */
    public void setTotalPrice(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.TOTAL_PRICE</code>.
     */
    public Integer getTotalPrice() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>TB_PRODUCT_TRADE.CUSTOMER_NAME</code>.
     */
    public void setCustomerName(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.CUSTOMER_NAME</code>.
     */
    public String getCustomerName() {
        return (String) get(4);
    }

    /**
     * Setter for <code>TB_PRODUCT_TRADE.CUSTOMER_PHONE_NUM</code>.
     */
    public void setCustomerPhoneNum(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.CUSTOMER_PHONE_NUM</code>.
     */
    public String getCustomerPhoneNum() {
        return (String) get(5);
    }

    /**
     * Setter for <code>TB_PRODUCT_TRADE.IS_DELETED</code>.
     */
    public void setIsDeleted(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.IS_DELETED</code>.
     */
    public Integer getIsDeleted() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>TB_PRODUCT_TRADE.CREATED_ID</code>.
     */
    public void setCreatedId(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.CREATED_ID</code>.
     */
    public String getCreatedId() {
        return (String) get(7);
    }

    /**
     * Setter for <code>TB_PRODUCT_TRADE.CREATED_AT</code>.
     */
    public void setCreatedAt(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.CREATED_AT</code>.
     */
    public Timestamp getCreatedAt() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>TB_PRODUCT_TRADE.UPDATED_ID</code>.
     */
    public void setUpdatedId(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.UPDATED_ID</code>.
     */
    public String getUpdatedId() {
        return (String) get(9);
    }

    /**
     * Setter for <code>TB_PRODUCT_TRADE.UPDATED_AT</code>.
     */
    public void setUpdatedAt(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>TB_PRODUCT_TRADE.UPDATED_AT</code>.
     */
    public Timestamp getUpdatedAt() {
        return (Timestamp) get(10);
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<Integer, Integer, Integer, Integer, String, String, Integer, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<Integer, Integer, Integer, Integer, String, String, Integer, String, Timestamp, String, Timestamp> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return TbProductTrade.TB_PRODUCT_TRADE.ID;
    }

    @Override
    public Field<Integer> field2() {
        return TbProductTrade.TB_PRODUCT_TRADE.PRODUCT_MASTER_ID;
    }

    @Override
    public Field<Integer> field3() {
        return TbProductTrade.TB_PRODUCT_TRADE.AMOUNT;
    }

    @Override
    public Field<Integer> field4() {
        return TbProductTrade.TB_PRODUCT_TRADE.TOTAL_PRICE;
    }

    @Override
    public Field<String> field5() {
        return TbProductTrade.TB_PRODUCT_TRADE.CUSTOMER_NAME;
    }

    @Override
    public Field<String> field6() {
        return TbProductTrade.TB_PRODUCT_TRADE.CUSTOMER_PHONE_NUM;
    }

    @Override
    public Field<Integer> field7() {
        return TbProductTrade.TB_PRODUCT_TRADE.IS_DELETED;
    }

    @Override
    public Field<String> field8() {
        return TbProductTrade.TB_PRODUCT_TRADE.CREATED_ID;
    }

    @Override
    public Field<Timestamp> field9() {
        return TbProductTrade.TB_PRODUCT_TRADE.CREATED_AT;
    }

    @Override
    public Field<String> field10() {
        return TbProductTrade.TB_PRODUCT_TRADE.UPDATED_ID;
    }

    @Override
    public Field<Timestamp> field11() {
        return TbProductTrade.TB_PRODUCT_TRADE.UPDATED_AT;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public Integer component2() {
        return getProductMasterId();
    }

    @Override
    public Integer component3() {
        return getAmount();
    }

    @Override
    public Integer component4() {
        return getTotalPrice();
    }

    @Override
    public String component5() {
        return getCustomerName();
    }

    @Override
    public String component6() {
        return getCustomerPhoneNum();
    }

    @Override
    public Integer component7() {
        return getIsDeleted();
    }

    @Override
    public String component8() {
        return getCreatedId();
    }

    @Override
    public Timestamp component9() {
        return getCreatedAt();
    }

    @Override
    public String component10() {
        return getUpdatedId();
    }

    @Override
    public Timestamp component11() {
        return getUpdatedAt();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public Integer value2() {
        return getProductMasterId();
    }

    @Override
    public Integer value3() {
        return getAmount();
    }

    @Override
    public Integer value4() {
        return getTotalPrice();
    }

    @Override
    public String value5() {
        return getCustomerName();
    }

    @Override
    public String value6() {
        return getCustomerPhoneNum();
    }

    @Override
    public Integer value7() {
        return getIsDeleted();
    }

    @Override
    public String value8() {
        return getCreatedId();
    }

    @Override
    public Timestamp value9() {
        return getCreatedAt();
    }

    @Override
    public String value10() {
        return getUpdatedId();
    }

    @Override
    public Timestamp value11() {
        return getUpdatedAt();
    }

    @Override
    public TbProductTradeRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public TbProductTradeRecord value2(Integer value) {
        setProductMasterId(value);
        return this;
    }

    @Override
    public TbProductTradeRecord value3(Integer value) {
        setAmount(value);
        return this;
    }

    @Override
    public TbProductTradeRecord value4(Integer value) {
        setTotalPrice(value);
        return this;
    }

    @Override
    public TbProductTradeRecord value5(String value) {
        setCustomerName(value);
        return this;
    }

    @Override
    public TbProductTradeRecord value6(String value) {
        setCustomerPhoneNum(value);
        return this;
    }

    @Override
    public TbProductTradeRecord value7(Integer value) {
        setIsDeleted(value);
        return this;
    }

    @Override
    public TbProductTradeRecord value8(String value) {
        setCreatedId(value);
        return this;
    }

    @Override
    public TbProductTradeRecord value9(Timestamp value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public TbProductTradeRecord value10(String value) {
        setUpdatedId(value);
        return this;
    }

    @Override
    public TbProductTradeRecord value11(Timestamp value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public TbProductTradeRecord values(Integer value1, Integer value2, Integer value3, Integer value4, String value5, String value6, Integer value7, String value8, Timestamp value9, String value10, Timestamp value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TbProductTradeRecord
     */
    public TbProductTradeRecord() {
        super(TbProductTrade.TB_PRODUCT_TRADE);
    }

    /**
     * Create a detached, initialised TbProductTradeRecord
     */
    public TbProductTradeRecord(Integer id, Integer productMasterId, Integer amount, Integer totalPrice, String customerName, String customerPhoneNum, Integer isDeleted, String createdId, Timestamp createdAt, String updatedId, Timestamp updatedAt) {
        super(TbProductTrade.TB_PRODUCT_TRADE);

        setId(id);
        setProductMasterId(productMasterId);
        setAmount(amount);
        setTotalPrice(totalPrice);
        setCustomerName(customerName);
        setCustomerPhoneNum(customerPhoneNum);
        setIsDeleted(isDeleted);
        setCreatedId(createdId);
        setCreatedAt(createdAt);
        setUpdatedId(updatedId);
        setUpdatedAt(updatedAt);
    }
}
