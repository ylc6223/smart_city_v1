package com.belong.smart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultBean {
    private String code;
    private String msg;
    private Object data;

    // 成功的数据响应
    public static ResultBean success(Object data) {
        return new ResultBean("200", "操作成功", data);
    }

    public static ResultBean success(String code, String msg, Object data) {
        return new ResultBean(code, msg, data);
    }

    // 失败的数据响应
    public static ResultBean fail(String msg) {
        return new ResultBean("500", msg, null);
    }

    public static ResultBean fail(String code, String msg, Object data) {
        return new ResultBean(code, msg, data);
    }
}
