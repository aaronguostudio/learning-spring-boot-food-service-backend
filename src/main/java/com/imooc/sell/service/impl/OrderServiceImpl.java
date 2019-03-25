package com.imooc.sell.service.impl;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        // 1. 查询商品（数量，价格）

        // 2. 计算总价

        // 3. 写入订单数据库（ orderMaster and orderDetail ）

        // 4. 扣除库存
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
