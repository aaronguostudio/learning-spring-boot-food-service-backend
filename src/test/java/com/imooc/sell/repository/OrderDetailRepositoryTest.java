package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("2");
        orderDetail.setOrderId("1");
        orderDetail.setProductId("1");
        orderDetail.setProductName("MacBook Pro 15");
        orderDetail.setProductPrice(BigDecimal.valueOf(12.3));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductIcon("/test");

        OrderDetail result = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId("1");
        Assert.assertEquals(2, orderDetailList.size());
    }
}