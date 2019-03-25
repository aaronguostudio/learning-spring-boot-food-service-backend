package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum TestEnum {
    TEST(10, "test")
    ;

    private Integer code;
    private String mes;
    TestEnum(Integer code, String mes) {
        this.code = code;
        this.mes = mes;
    }
}
