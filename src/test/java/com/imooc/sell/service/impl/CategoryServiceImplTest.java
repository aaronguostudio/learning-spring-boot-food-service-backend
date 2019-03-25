package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(14);
        Assert.assertNotEquals(null, productCategory);
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("UX & UI", 3);
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}