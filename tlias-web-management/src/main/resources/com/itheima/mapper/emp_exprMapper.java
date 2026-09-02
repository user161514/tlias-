package com.itheima.mapper;

import com.itheima.pojo.emp;
import com.itheima.pojo.emp_expr;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface emp_exprMapper {
    /**
     * 保存员工经历信息
     */
    void saveBatch(@Param("exprList") List<emp_expr> empExpr);


    void delete(List<Integer> list);
}
