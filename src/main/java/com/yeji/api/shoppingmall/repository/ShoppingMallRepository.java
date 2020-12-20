package com.yeji.api.shoppingmall.repository;

import com.google.common.collect.Lists;
import com.yeji.api.shoppingmall.domain.TbProductMaster;
import com.yeji.api.shoppingmall.model.ProductDetail;
import com.yeji.api.shoppingmall.packet.ReqBuyProduct;
import com.yeji.api.shoppingmall.packet.ReqInsertProduct;
import com.yeji.api.shoppingmall.packet.ResProductInfo;
import com.yeji.utils.common.CommonUtils;
import com.yeji.utils.common.JooqUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.yeji.h2.entity.tables.TbProductMaster.*;
import static com.yeji.h2.entity.tables.TbProductModifyHist.*;
import static com.yeji.h2.entity.tables.TbProductTrade.*;
import static org.jooq.impl.DSL.select;

@Slf4j
@Repository
@RequiredArgsConstructor
@Transactional
public class ShoppingMallRepository {
    private final DSLContext dsl;

    /**
     * 상품 리스트 조회
     * @return
     */
    public List<TbProductMaster> getProductList(int offset) {
        return dsl.select(getFieldList())
                .from(TB_PRODUCT_MASTER)
                .where(TB_PRODUCT_MASTER.IS_DELETED.isFalse())
                .groupBy(TB_PRODUCT_MASTER.GROUP_CODE)
                .limit(offset, 9)
                .fetchInto(TbProductMaster.class);
    }

    /**
     * 상품 리스트 카운팅
     * @return
     */
    public int getProductCount(int offset) {
        return dsl.selectCount().from(
                select(TB_PRODUCT_MASTER.GROUP_CODE).from(TB_PRODUCT_MASTER)
                        .where(TB_PRODUCT_MASTER.IS_DELETED.isFalse())
                        .groupBy(TB_PRODUCT_MASTER.GROUP_CODE)
                        .limit(offset, 9)
        )
                .fetchOneInto(Integer.class);
    }

    /**
     * 상품 상세 정보 조회
     * @param groupCode
     * @return
     */
    public ResProductInfo getProductInfo(String groupCode) {
        return dsl.select(getFieldList())
                .from(TB_PRODUCT_MASTER)
                .where(TB_PRODUCT_MASTER.GROUP_CODE.eq(groupCode))
                .and(TB_PRODUCT_MASTER.IS_DELETED.isFalse())
                .limit(1)
                .fetchOneInto(ResProductInfo.class);
    }

    /**
     * 상품 상세 옵션 정보 조회
     * @param groupCode
     * @return
     */
    public List<ProductDetail> getProductDetail(String groupCode) {
        return dsl.select(
                TB_PRODUCT_MASTER.ID,
                TB_PRODUCT_MASTER.PRODUCT_DETAIL_OPTION,
                TB_PRODUCT_MASTER.STOCK)
                .from(TB_PRODUCT_MASTER)
                .where(TB_PRODUCT_MASTER.GROUP_CODE.eq(groupCode))
                .and(TB_PRODUCT_MASTER.IS_DELETED.isFalse())
                .fetchInto(ProductDetail.class);
    }

    /**
     * 상품 재고 리턴
     * @param id
     * @return
     */
    public int getProductStock(Integer id) {
        return dsl.select(TB_PRODUCT_MASTER.STOCK)
                .from(TB_PRODUCT_MASTER)
                .where(TB_PRODUCT_MASTER.ID.eq(id))
                .fetchOneInto(Integer.class);
    }
    /**
     * 상품 구매
     * @param id
     * @return
     */
    public int buyProduct(Integer id, ReqBuyProduct reqBuyProduct) {
        return dsl.update(TB_PRODUCT_MASTER)
                .set(TB_PRODUCT_MASTER.STOCK, TB_PRODUCT_MASTER.STOCK.minus(reqBuyProduct.getAmount()))
                .where(TB_PRODUCT_MASTER.ID.eq(id))
                .execute();
    }

    /**
     * 상품 구매 히스토리 등록
     * @param id
     * @param reqBuyProduct
     * @return
     */
    public int insertProductBuyHistory(Integer id, ReqBuyProduct reqBuyProduct) {
        return dsl.insertInto(TB_PRODUCT_TRADE)
                .set(TB_PRODUCT_TRADE.PRODUCT_MASTER_ID, id)
                .set(TB_PRODUCT_TRADE.AMOUNT, reqBuyProduct.getAmount())
                .set(TB_PRODUCT_TRADE.TOTAL_PRICE, reqBuyProduct.getTotalPrice())
                .set(TB_PRODUCT_TRADE.CUSTOMER_NAME, reqBuyProduct.getCustomerName())
                .set(TB_PRODUCT_TRADE.CUSTOMER_PHONE_NUM, reqBuyProduct.getCustomerPhoneNum())
                .set(TB_PRODUCT_TRADE.IS_DELETED, 0)
                .set(TB_PRODUCT_TRADE.CREATED_ID, reqBuyProduct.getCustomerName())
                .set(TB_PRODUCT_TRADE.CREATED_AT, Timestamp.valueOf(LocalDateTime.now()))
                .execute();
    }


    /**
     * 상품 등록
     * @param tbProductMaster
     * @return
     */
    public int insertProduct(TbProductMaster tbProductMaster) {
        if(CommonUtils.objectEmpty(tbProductMaster)) return 0;

        List<Field<?>> selectFieldList = getFieldList();
        selectFieldList.add(TB_PRODUCT_MASTER.CREATED_ID);
        selectFieldList.add(TB_PRODUCT_MASTER.CREATED_AT);
        selectFieldList.add(TB_PRODUCT_MASTER.UPDATED_ID);
        selectFieldList.add(TB_PRODUCT_MASTER.UPDATED_AT);

        InsertSetStep<?> insert = dsl.insertInto(TB_PRODUCT_MASTER);

        InsertSetMoreStep<?> moreStep = insert
                .set(TB_PRODUCT_MASTER.PRODUCT_DETAIL_OPTION, tbProductMaster.getProductDetailOption())
                .set(TB_PRODUCT_MASTER.STOCK, tbProductMaster.getStock());
        moreStep = JooqUtils.setInsertSetMoreStep(moreStep, selectFieldList, tbProductMaster, false, false);
        return moreStep.execute();
    }

    /**
     * 상품 삭제
     * @param groupCode
     * @return
     */
    public int deleteProduct(String groupCode) {
        return dsl.update(TB_PRODUCT_MASTER)
                .set(TB_PRODUCT_MASTER.IS_DELETED, 1)
                .where(TB_PRODUCT_MASTER.GROUP_CODE.eq(groupCode))
                .execute();
    }

    /**
     * 상품 수정 히스토리 등록
     * @param tbProductMaster
     * @return
     */
    public int insertUpdateHistory(TbProductMaster tbProductMaster) {
        if(CommonUtils.objectEmpty(tbProductMaster)) return 0;

        return dsl.insertInto(TB_PRODUCT_MODIFY_HIST)
                .set(TB_PRODUCT_MODIFY_HIST.PRODUCT_NAME, tbProductMaster.getProductName())
                .set(TB_PRODUCT_MODIFY_HIST.PRODUCT_MASTER_ID, tbProductMaster.getId())
                .set(TB_PRODUCT_MODIFY_HIST.DESCRIPTION, tbProductMaster.getDescription())
                .set(TB_PRODUCT_MODIFY_HIST.IMAGE, tbProductMaster.getImage())
                .set(TB_PRODUCT_MODIFY_HIST.PRICE, tbProductMaster.getPrice())
                .set(TB_PRODUCT_MODIFY_HIST.PRODUCT_DETAIL_OPTION, tbProductMaster.getProductDetailOption())
                .set(TB_PRODUCT_MODIFY_HIST.STOCK, tbProductMaster.getStock())
                .execute();
    }

    /**
     * 상품 Field 리스트
     * @return
     */
    private List<Field<?>> getFieldList() {
        return Lists.newArrayList(
                TB_PRODUCT_MASTER.PRODUCT_NAME,
                TB_PRODUCT_MASTER.PRICE,
                TB_PRODUCT_MASTER.IMAGE,
                TB_PRODUCT_MASTER.DESCRIPTION,
                TB_PRODUCT_MASTER.GROUP_CODE
        );
    }
}
