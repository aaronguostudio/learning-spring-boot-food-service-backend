package com.imooc.sell.viewobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultViewObject<T> {
    // 错误码
    private Integer code;

    // 信息
    private String msg;

    // 详情
    private T data;
}
