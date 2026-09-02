package com.itheima.mapper;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.Logininfo;
import com.itheima.pojo.emp;
import com.itheima.pojo.emp1;
import lombok.extern.java.Log;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface empMapper<T> {
    //@Select("select  s.*,d.name dept_name from tlias.emp s left join tlias.dept d on s.dept_id = d.id where s.name like '%name%' and gender=s.gender and s.entry_date between s.create_time and s.update_time order by update_time desc")
    List<emp> Limit(emp1 k);

    /**
     * 新增员工基本信息
     */
    @Options(useGeneratedKeys = true,keyProperty = "id")//这里返回值会放在你传入过来的实体类对象属性中
    @Insert("insert into tlias.emp (username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entry_date}, #{dept_id}, #{create_time}, #{update_time})")
    void save(emp k);
    void delete(List<Integer> ids);

   List<emp> select(Integer id);
    void updateById(emp k);
    @MapKey("job")
    List<Map<String,Object>> countJob();
    @MapKey("gender")
    List<Map<String,Object>> countGender();
    Logininfo Login(Logininfo empList);
}
