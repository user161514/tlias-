package com.itheima.Service;

import com.itheima.pojo.Emp22;

import java.util.List;

public interface Emp22service {
    List<Emp22> select(Integer id);

    void emp22Add(String name);

    List<Emp22> select1();
}
