package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Result {
    private Integer code;      // 状态码：200=成功，其他=失败
    private String msg;        // 消息
    private Object data;       // 返回的数据
    public static Result success()
    {
        return new Result(200, "success", null);
    }
    // 快速构建成功响应
    public static Result success(Object data) {
        return new Result(200, "success", data);
    }

    // 快速构建失败响应
    public static Result error(String msg) {

        return new Result(500, msg, null);
    }
}