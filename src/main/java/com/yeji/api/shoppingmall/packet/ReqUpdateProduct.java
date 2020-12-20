package com.yeji.api.shoppingmall.packet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
@ApiModel("상품 등록 요청 객체")
public class ReqUpdateProduct {

    @ApiModelProperty("상품명")
    private String productName;
    @ApiModelProperty("상품 그룹 코드")
    private String productGroupCode;
    @ApiModelProperty("상품 가격")
    private String price;
    @ApiModelProperty("상품 옵션")
    private List<String> productOption;
    @ApiModelProperty("상품 재고")
    private List<String> amount;
    @ApiModelProperty("상품 아이디")
    private List<String> productId;
    @ApiModelProperty("상품 설명")
    private String description;
    @ApiModelProperty("상품 이미지 경로")
    private String imageFilePath;

}
