package com.itheima.Service;

import com.itheima.pojo.user;

import java.util.List;

public interface service {
    /**
     * 查询所有的部门数据
     */
    void getDate(Integer id);
    void insert(user m);

    List<user> selectById(Integer id);
}
