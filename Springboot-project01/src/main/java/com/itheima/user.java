package com.itheima;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class user {
//根据user表内的字段创建变量
    private int id;
    private String username;
    private int password;
    private String name;
    private int age;

    public user(int id, int password) {
        this.id = id;
        this.password = password;
    }

    public user(int id, int password, int age) {
        this.id = id;
        this.password = password;
        this.age = age;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}'+"";

    }
}
