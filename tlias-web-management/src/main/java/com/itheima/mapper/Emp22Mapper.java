package com.itheima.mapper;

import com.itheima.pojo.Emp22;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Emp22Mapper {
    List<Emp22> select(@Param("id") Integer id);

    void insert(String name);

    List<Emp22> select1();
}
