package com.yeji.api.shoppingmall.controller;

import com.yeji.api.shoppingmall.domain.TbProductMaster;
import com.yeji.api.shoppingmall.service.ShoppingMallService;
import com.yeji.common.domain.CommonResult;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static com.yeji.common.constant.ResCode.SUCCESS;

@Slf4j
@Controller
@RequiredArgsConstructor
//@RequestMapping("/product")
@Api(value = "쇼핑몰 컨트롤러", tags = "쇼핑몰 API")
public class ShoppingMallController {

    private final ShoppingMallService shoppingMallService;

    @GetMapping("/list")
    public String getProductList(Model model) {
        model.addAttribute("result", shoppingMallService.getProductList(0));
        return "main";
    }
    @GetMapping("/{groupCode}")
    public String getProductInfo(Model model, @PathVariable String groupCode) {
        model.addAttribute("result", shoppingMallService.getProductInfo(groupCode));
        return "productDetail";
    }

    @GetMapping("/insert")
    public String insertProductView() {
        return "productInsert";
    }

    @GetMapping("/update")
    public String updateProductView(Model model, @RequestParam String groupCode) {
        model.addAttribute("result", shoppingMallService.getProductInfo(groupCode));
        return "productUpdate";
    }

}
