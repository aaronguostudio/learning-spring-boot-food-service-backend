package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("2");
        orderMaster.setBuyerName("Aaron");
        orderMaster.setBuyerOpenid("aaron");
        orderMaster.setBuyerAddress("Beijing");
        orderMaster.setBuyerPhone("5877006166");
        orderMaster.setOrderAmount(BigDecimal.valueOf(12.3));
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        Page<OrderMaster> orderMasterList = orderMasterRepository.findByBuyerOpenid("aaron", PageRequest.of(0, 1));
        Assert.assertNotEquals(0, orderMasterList.getTotalElements());
    }
}