package com.yeji.api.shoppingmall.controller;

import com.yeji.api.shoppingmall.domain.TbProductMaster;
import com.yeji.api.shoppingmall.packet.ReqBuyProduct;
import com.yeji.api.shoppingmall.packet.ReqInsertProduct;
import com.yeji.api.shoppingmall.packet.ReqUpdateProduct;
import com.yeji.api.shoppingmall.packet.ResProductList;
import com.yeji.api.shoppingmall.service.ShoppingMallService;
import com.yeji.common.domain.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Api(value = "쇼핑몰 컨트롤러", tags = "쇼핑몰 API")
public class ShoppingMallRestController {

    private final ShoppingMallService shoppingMallService;

    @GetMapping("/list/{offset}")
    public CommonResult<ResProductList> getProductList(@PathVariable Integer offset) {
        return shoppingMallService.getProductList(offset);
    }

    @ApiOperation("상품 구매")
    @PatchMapping("/buy/{id}")
    public CommonResult<Boolean> buyProduct(@PathVariable Integer id, @RequestBody ReqBuyProduct reqBuyProduct){
        return shoppingMallService.buyProduct(id, reqBuyProduct);
    }

    @ApiOperation("상품 삭제")
    @PutMapping("/delete/{groupCode}")
    public CommonResult<Boolean> deleteProduct(@PathVariable String groupCode){
        return shoppingMallService.deleteProduct(groupCode);
    }

    @ApiOperation("상품 등록")
    @PostMapping("/add")
    public CommonResult<?> insertProduct(@RequestParam(value = "image", required = false) MultipartFile file, ReqInsertProduct reqInsertProduct) {
        return shoppingMallService.insertProduct(file, reqInsertProduct);
    }

    @ApiOperation("상품 수정")
    @PostMapping("/update/{groupCode}")
    public CommonResult<?> insertProduct(@PathVariable String groupCode, @RequestParam(value = "image", required = false) MultipartFile file, ReqUpdateProduct reqUpdateProduct) {
        return shoppingMallService.updateProduct(groupCode, file, reqUpdateProduct);
    }
}
