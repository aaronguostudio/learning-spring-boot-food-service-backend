package com.imooc.sell.controller;

import com.imooc.sell.converter.OrderForm2OrderDTOConverter;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.utils.ResultViewObjectUtil;
import com.imooc.sell.viewobject.ResultViewObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    // 创建订单
    @PostMapping("/create")
    public ResultViewObject<Map<String, String>> create (
            @Valid OrderForm orderForm,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            log.error("[Create Order] parameters are invalid, orderForm = {}", orderForm);
            throw new SellException(
                    ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage()
            );
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("[Create Order] shopping card can not be empty");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultViewObjectUtil.success(map);
    }

    // 订单列表
    @GetMapping("/list")
    public ResultViewObject<List<OrderDTO>> list(
        @RequestParam("openid") String openid,
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        if (StringUtils.isEmpty(openid)) {
            log.error("[Query order list] openid is null");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = PageRequest.of(page, size);

        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultViewObjectUtil.success(orderDTOPage.getContent());
    }


    // 订单详情

    // 取消订单
}
