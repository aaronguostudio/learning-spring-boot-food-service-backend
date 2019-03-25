package com.imooc.sell.controller;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.ProductService;
import com.imooc.sell.utils.ResultViewObjectUtil;
import com.imooc.sell.viewobject.ProductInfoViewObject;
import com.imooc.sell.viewobject.ProductViewObject;
import com.imooc.sell.viewobject.ResultViewObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// RestController will return a json format

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultViewObject list() {

        // 1. 查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        // 2. 查询类目（一次性查询）
        // 传统的 loop 方式
        // List<Integer> categoryTypeList = new ArrayList<>();
        /*for (ProductInfo productInfo : productInfoList) {
            categoryTypeList.add(productInfo.getCategoryType());
        }*/

        // lambda
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        // 3. 数据拼装
        List<ProductViewObject> productViewObjectList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductViewObject productViewObject = new ProductViewObject();
            productViewObject.setCategoryType(productCategory.getCategoryType());
            productViewObject.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoViewObject> productInfoViewObjectList= new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType() == productCategory.getCategoryType()) {
                    ProductInfoViewObject productInfoViewObject = new ProductInfoViewObject();
                    BeanUtils.copyProperties(productInfo, productInfoViewObject);
                    productInfoViewObjectList.add(productInfoViewObject);
                }
            }
            productViewObject.setProductInfoViewObjectList(productInfoViewObjectList);
            productViewObjectList.add(productViewObject);
        }

        return ResultViewObjectUtil.success(productViewObjectList);
    }
}
