package com.imooc.sell.utils;

import com.imooc.sell.viewobject.ResultViewObject;

public class ResultViewObjectUtil {
    public static ResultViewObject success(Object object) {
        ResultViewObject resultViewObject = new ResultViewObject();
        resultViewObject.setData(object);
        resultViewObject.setCode(0);
        resultViewObject.setMsg("Success");
        return resultViewObject;
    }

    public static ResultViewObject success() {
        return success(null);
    }

    public static ResultViewObject error(Integer code, String msg) {
        ResultViewObject resultViewObject = new ResultViewObject();
        resultViewObject.setCode(code);
        resultViewObject.setMsg(msg);
        return resultViewObject;
    }
}
