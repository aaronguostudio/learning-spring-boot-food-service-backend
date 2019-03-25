package com.imooc.sell.repository;

import com.imooc.sell.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void testSave() {
        SellerInfo sellerInfo = new SellerInfo("1", "a", "b", "c");
        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }
}