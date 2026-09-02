package com.itheima;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Dao {
//    @Select("select * from (select * from user where password!=#{password})  k ")
    List<user> b(@Param("id") int ee, String password);
}

