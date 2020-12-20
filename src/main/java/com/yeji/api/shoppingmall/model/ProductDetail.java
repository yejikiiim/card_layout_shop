package com.yeji.api.shoppingmall.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@ApiModel("상품 상세 옵션 정보 객체")
public class ProductDetail {
    @ApiModelProperty("상품 ID")
    private Integer id;
    @ApiModelProperty("상품 상세 옵션")
    private String productDetailOption;
    @ApiModelProperty("상품 재고")
    private Integer stock;

}
