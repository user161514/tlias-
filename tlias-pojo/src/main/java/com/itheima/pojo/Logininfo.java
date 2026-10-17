package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Logininfo {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private String token; // 专门存放 jwt 令牌
}
