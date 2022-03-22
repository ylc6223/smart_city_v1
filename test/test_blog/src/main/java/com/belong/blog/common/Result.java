package com.belong.blog.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String code;
    private String msg;
    private Object data;

    // 成功的数据响应
    public static Result success(Object data) {
        return new Result("200", "操作成功", data);
    }

    public static Result success(String code, String msg, Object data) {
        return new Result(code, msg, data);
    }


    // 失败的数据响应
    public static Result fail( String msg) {
        return new Result("500", msg, null);
    }

    public static Result fail(String code, String msg, Object data) {
        return new Result(code, msg, data);
    }

}
