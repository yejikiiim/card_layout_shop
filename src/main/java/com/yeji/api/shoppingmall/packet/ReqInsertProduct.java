package com.yeji.api.shoppingmall.packet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@ApiModel("상품 등록 요청 객체")
public class ReqInsertProduct {

    @ApiModelProperty("상품명")
    private String productName;
    @ApiModelProperty("상품 그룹 코드")
    private String productGroupCode;
    @ApiModelProperty("상품 가격")
    private Integer price;
    @ApiModelProperty("상품 옵션")
    private List<String> productOption;
    @ApiModelProperty("상품 재고")
    private List<String> amount;
    @ApiModelProperty("상품 설명")
    private String description;

    @ApiModelProperty("상품 이미지 경로")
    private String imageFilePath;

    @Builder
    public ReqInsertProduct(String productName, String productGroupCode, Integer price, List<String> productOption, List<String> amount, String description) {
        this.productName = productName;
        this.productGroupCode = productGroupCode;
        this.price = price;
        this.productOption = productOption;
        this.amount = amount;
        this.description = description;
    }
}
