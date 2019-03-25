package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(0, "On Stock"),
    DOWN(1, "Out of Stock")
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
