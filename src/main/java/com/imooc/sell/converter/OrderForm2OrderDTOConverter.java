package com.imooc.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert (OrderForm orderForm) {

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName( orderForm.getName() );
        orderDTO.setBuyerPhone( orderForm.getPhone() );
        orderDTO.setBuyerAddress( orderForm.getAddress() );
        orderDTO.setBuyerOpenid( orderForm.getOpenid() );

        List<OrderDetail> orderDetailList = new ArrayList<>();
        // 转换 items 需要放到订单详情列表里面，传入的是 JSON 格式，可以转换为需要的格式 gson
        try {
            orderDetailList = gson.fromJson(
                    orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType()
            );
        } catch (Exception e) {
            log.error("[Object Converter] error, string = {}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;

    }
}
