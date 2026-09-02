package com.itheima.Service;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.emp;
import com.itheima.pojo.emp1;
import org.apache.ibatis.annotations.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface Empservice {
     PageResult<emp> Limit(emp1 k);
     void save(emp k);

     void delete(List<Integer> ids);

     List<emp> select(Integer id);

     void update(emp k);

}

