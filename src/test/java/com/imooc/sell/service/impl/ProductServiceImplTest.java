package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("a1");
        Assert.assertEquals("a1", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertEquals(1, productInfoList.size());
    }

    @Test
    public void findAll() {
        Page<ProductInfo> page = productService.findAll(PageRequest.of(0, 1));
        Assert.assertNotEquals(0, page.getSize());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo("a3", "test", new BigDecimal(12), 100, "Desc", "/test", ProductStatusEnum.DOWN.getCode(), 1);
        ProductInfo result = productService.save(productInfo);
        Assert.assertNotNull(result);
    }
}