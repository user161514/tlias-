package com.itheima.Service.serviceimpl;

import com.itheima.Service.ReportService;
import com.itheima.mapper.empMapper;
import com.itheima.pojo.JobOption;
import com.itheima.pojo.emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private empMapper empMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JobOption getEmpJobData() {
        //调用mapper接口获取统计数据
        //1. 调用mapper
        List<Map<String,Object>> d=empMapper.countJob();
        List<Object> list = d.stream().map(map -> map.get("job")).toList();
        List<Object> list1 = d.stream().map(map -> map.get("num")).toList();

        //组装结果并返回
        return new JobOption(list,list1);
    }

    @Override
    public List<Map<String, Object>> getGender() {
        List list = empMapper.countGender();
        return list;
    }
}
