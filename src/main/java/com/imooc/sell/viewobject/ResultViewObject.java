package com.imooc.sell.viewobject;

import lombok.Data;

@Data
public class ResultViewObject<T> {
    // 错误码
    private Integer code;

    // 信息
    private String msg;

    // 详情
    private T data;
}
