package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

public class ProductException extends RuntimeException {
    private Integer code;
    ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
