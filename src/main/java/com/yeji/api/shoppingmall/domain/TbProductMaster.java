package com.yeji.api.shoppingmall.domain;

import com.yeji.api.shoppingmall.packet.ReqInsertProduct;
import com.yeji.api.shoppingmall.packet.ReqUpdateProduct;
import com.yeji.utils.common.ParseUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.apache.poi.ss.formula.functions.T;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel("상품 정보 도메인 객체")
public class TbProductMaster {
    @ApiModelProperty("상품 ID")
    private Integer id;
    @ApiModelProperty("상품 그룹 코드")
    private String groupCode;
    @ApiModelProperty("상품명")
    private String productName;
    @ApiModelProperty("상품 상세 옵션")
    private String productDetailOption;
    @ApiModelProperty("상품 가격")
    private Integer price;
    @ApiModelProperty("상품 이미지")
    private String image;
    @ApiModelProperty("상품 재고")
    private Integer stock;
    @ApiModelProperty("상품 상세 설명")
    private String description;
    @ApiModelProperty("삭제 여부")
    private Boolean isDeleted;
    @ApiModelProperty(value = "생성자")
    private String createdId;
    @ApiModelProperty(value = "생성일시")
    private LocalDateTime createdAt;
    @ApiModelProperty(value = "수정자")
    private String updatedId;
    @ApiModelProperty(value = "수정일시")
    private LocalDateTime updatedAt;

    @Builder
    public TbProductMaster(Integer id, String groupCode, String productName, String productDetailOption, Integer price, String image, Integer stock, String description, Boolean isDeleted, String createdId, LocalDateTime createdAt, String updatedId, LocalDateTime updatedAt) {
        this.id = id;
        this.groupCode = groupCode;
        this.productName = productName;
        this.productDetailOption = productDetailOption;
        this.price = price;
        this.image = image;
        this.stock = stock;
        this.description = description;
        this.isDeleted = isDeleted;
        this.createdId = createdId;
        this.createdAt = createdAt;
        this.updatedId = updatedId;
        this.updatedAt = updatedAt;
    }

    /**
     * 상품 등록 객체 셋팅
     * @param reqInsertProduct
     */
    public TbProductMaster(ReqInsertProduct reqInsertProduct) {
        this.productName = reqInsertProduct.getProductName();
        this.groupCode = reqInsertProduct.getProductGroupCode();
        this.price = reqInsertProduct.getPrice();
        this.description = reqInsertProduct.getDescription();
        this.image = reqInsertProduct.getImageFilePath();
    }

    /**
     * 상품 수정 객체 셋팅
     * @param reqUpdateProduct
     */
    public TbProductMaster(ReqUpdateProduct reqUpdateProduct) {
        this.productName = reqUpdateProduct.getProductName();
        this.price = ParseUtils.parseInt(reqUpdateProduct.getPrice());
        this.image = reqUpdateProduct.getImageFilePath();
        this.description = reqUpdateProduct.getDescription();
    }
}
