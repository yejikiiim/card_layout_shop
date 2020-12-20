package com.yeji.api.shoppingmall.packet;

import com.yeji.api.shoppingmall.domain.TbProductMaster;
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
@ApiModel("상품리스트 응답 객체")
public class ResProductList {
    @ApiModelProperty("상품 리스트")
    private List<TbProductMaster> productList;
    @ApiModelProperty("리스트 총 갯수")
    private Integer totalCount;

    public ResProductList(List<TbProductMaster> productList, Integer totalCount) {
        this.productList = productList;
        this.totalCount = totalCount;
    }
}
