package com.itheima.mapper;

import com.itheima.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DeptMapper {
     @Update("delete from tlias.dept where id=#{id}")
      void selectAll(@Param("id") Integer id);
     @Update("insert into tlias.dept (id, name, create_time, update_time) values (#{id}, #{name}, #{createtime}, #{updatetime})")
     void insertDept(user m);
     @Select("select * from tlias.dept where id=#{id}")
     List<user> selectById(@Param("id") Integer id);
     @Update("update tlias.dept set name=#{name}, update_time=#{updatetime} where id=#{id}")
     void update(user k);
}
