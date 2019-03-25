package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    // 在测试里面添加 Transactional 就是完全的回滚
    @Test
    public void saveTest() {
        /*ProductCategory productCategory = repository.findById(4).orElse(null);
        productCategory.setCategoryType(3);
        repository.save(productCategory);*/

        ProductCategory productCategory = new ProductCategory("Programming", 1);
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(1, 2);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, result.size());
    }

//    @Test
//    public void findOneTest() {
//        Optional<ProductCategory> productCategory = repository.findById(14);
//        System.out.println(productCategory.toString());
//    }
//
//    @Test
//    @Transactional
//    public void updateTest() {
//        ProductCategory productCategory = repository.findById(1).orElse(null);
//        productCategory.setCategoryType(2);
//        productCategory.setCategoryName("UI & UX");
//        repository.save(productCategory);
//    }
}