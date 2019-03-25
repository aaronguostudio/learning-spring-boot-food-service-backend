package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductinfoRepositoryTest {
    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {
        ProductInfo productInfo = new ProductInfo("a1", "test", new BigDecimal(12), 100, "Desc", "/test", 0, 1);
        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, list.size());
    }
}