package com.yeji.api.shoppingmall.packet;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@ApiModel("상품 구매 요청 객체")
public class ReqBuyProduct {

    @ApiModelProperty("상품 주문 수량")
    private Integer amount;

    @ApiModelProperty("주문자명")
    private String customerName;

    @ApiModelProperty("주문자 연락처")
    private String customerPhoneNum;

    @ApiModelProperty("총가격")
    private Integer totalPrice;


}
