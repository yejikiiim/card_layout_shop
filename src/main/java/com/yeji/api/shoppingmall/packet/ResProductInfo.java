package com.yeji.api.shoppingmall.packet;

import com.yeji.api.shoppingmall.model.ProductDetail;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@ApiModel("상품정보 응답 객체")
public class ResProductInfo {
    @ApiModelProperty("상품 그룹 코드")
    private String groupCode;
    @ApiModelProperty("상품명")
    private String productName;
    @ApiModelProperty("상품 상세 옵션")
    private List<ProductDetail> productDetailList;
    @ApiModelProperty("상품 가격")
    private Integer price;
    @ApiModelProperty("상품 이미지")
    private String image;
    @ApiModelProperty("상품 상세 설명")
    private String description;
}
