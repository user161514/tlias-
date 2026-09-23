package com.itheima.mapper;

import com.itheima.pojo.Emp22;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface Emp22Mapper {
    List<Emp22> select(Emp22 emplist);
}
