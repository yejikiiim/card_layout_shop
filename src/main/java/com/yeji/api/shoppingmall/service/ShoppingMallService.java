package com.yeji.api.shoppingmall.service;

import com.yeji.api.shoppingmall.domain.TbProductMaster;
import com.yeji.api.shoppingmall.packet.*;
import com.yeji.api.shoppingmall.repository.ShoppingMallRepository;
import com.yeji.common.domain.CommonResult;
import com.yeji.utils.common.CommonUtils;
import com.yeji.utils.common.ParseUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static com.yeji.common.constant.ResCode.EXCEED_MAXIMUM_DATA;
import static com.yeji.common.constant.ResCode.SUCCESS;


@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ShoppingMallService {

    //@Value("${properties.file.upload-dir}")
    //private String fileUploadPath;

    private final ShoppingMallRepository shoppingMallRepository;

    private final Path root = Paths.get("src/main/resources/static/img/");

    /**
     * 상품 리스트 조회
     * @return
     */
    public CommonResult<ResProductList> getProductList(Integer offset) {
        List<TbProductMaster> productList = shoppingMallRepository.getProductList(offset);
        return new CommonResult<>(SUCCESS, SUCCESS.getMessage(), new ResProductList(productList, shoppingMallRepository.getProductCount(offset)));
    }

    /**
     * 상품 상세 정보 조회
     * @param groupCode
     * @return
     */
    public CommonResult<ResProductInfo> getProductInfo(String groupCode) {
        ResProductInfo productInfo = shoppingMallRepository.getProductInfo(groupCode);
        productInfo.setProductDetailList(shoppingMallRepository.getProductDetail(groupCode));
        return new CommonResult<>(SUCCESS, SUCCESS.getMessage(), productInfo);
    }

    /**
     * 상품 구매
     * @param id
     * @return
     */
    public CommonResult<Boolean> buyProduct(Integer id, ReqBuyProduct reqBuyProduct) {
        int stock = shoppingMallRepository.getProductStock(id);
        if(stock - ParseUtils.parseInt(reqBuyProduct.getAmount()) < 0)
            return new CommonResult<>(EXCEED_MAXIMUM_DATA, EXCEED_MAXIMUM_DATA.getMessage(), BooleanUtils.toBoolean(0));

        int resultCount = shoppingMallRepository.buyProduct(id, reqBuyProduct);
        shoppingMallRepository.insertProductBuyHistory(id, reqBuyProduct);
        return new CommonResult<>(SUCCESS, SUCCESS.getMessage(), BooleanUtils.toBoolean(resultCount));
    }

    /**
     * 상품 삭제
     * @param groupCode
     * @return
     */
    public CommonResult<Boolean> deleteProduct(String groupCode) {
        int resultCount = shoppingMallRepository.deleteProduct(groupCode);
        return new CommonResult<>(SUCCESS, SUCCESS.getMessage(), BooleanUtils.toBoolean(resultCount));
    }

    /**
     * 상품 등록
     * @param multipartFile
     * @param reqInsertProduct
     * @return
     */
    public CommonResult<?> insertProduct(MultipartFile multipartFile, ReqInsertProduct reqInsertProduct) {

        //파일 업로드
        String uploadPath = uploadImage(multipartFile);
        if(uploadPath != null) reqInsertProduct.setImageFilePath(uploadPath);

        int resultCount = 0;
        TbProductMaster tbProductMaster = new TbProductMaster(reqInsertProduct);
        for(int i=0; i<reqInsertProduct.getProductOption().size(); i++) {
            tbProductMaster.setProductDetailOption(reqInsertProduct.getProductOption().get(i));
            tbProductMaster.setStock(ParseUtils.parseInt(reqInsertProduct.getAmount().get(i)));

            resultCount += shoppingMallRepository.insertProduct(tbProductMaster);
        }
        return new CommonResult<>(SUCCESS, SUCCESS.getMessage(), resultCount);
    }

    /**
     * 상품정보 수정
     * @param groupCode
     * @param multipartFile
     * @param reqUpdateProduct
     * @return
     */
    public CommonResult<?> updateProduct(String groupCode, MultipartFile multipartFile, ReqUpdateProduct reqUpdateProduct) {
        String uploadPath = uploadImage(multipartFile);
        if(uploadPath != null) reqUpdateProduct.setImageFilePath(uploadPath);

        shoppingMallRepository.deleteProduct(groupCode);

        TbProductMaster updateProduct = new TbProductMaster(reqUpdateProduct);
        for(int i=0; i<reqUpdateProduct.getProductId().size(); i++) {
            updateProduct.setId(ParseUtils.parseInt(reqUpdateProduct.getProductId().get(i)));
            updateProduct.setStock(ParseUtils.parseInt(reqUpdateProduct.getAmount().get(i)));
            updateProduct.setProductDetailOption(reqUpdateProduct.getProductOption().get(i));
            shoppingMallRepository.insertUpdateHistory(updateProduct);
        }

        TbProductMaster insertProduct = new TbProductMaster(reqUpdateProduct);

        int resultCount = 0;
        for(int i=0; i<reqUpdateProduct.getProductOption().size(); i++) {
            insertProduct.setStock(ParseUtils.parseInt(reqUpdateProduct.getAmount().get(i)));
            insertProduct.setProductDetailOption(reqUpdateProduct.getProductOption().get(i));
            insertProduct.setGroupCode(groupCode);
            resultCount += shoppingMallRepository.insertProduct(insertProduct);
        }

        return new CommonResult<>(SUCCESS, SUCCESS.getMessage(), resultCount);
    }

    private String uploadImage(MultipartFile multipartFile) {
        if(multipartFile != null) {
            try {
                //Files.copy(multipartFile.getInputStream(), this.root.resolve(multipartFile.getOriginalFilename()));
                byte[] bytes = multipartFile.getBytes();
                Path path = Paths.get("src/main/resources/static/img/" + multipartFile.getOriginalFilename());
                Files.write(path, bytes);
            } catch (Exception e) {
                throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
            }
            return multipartFile.getOriginalFilename();
        }
        return null;
    }
}
