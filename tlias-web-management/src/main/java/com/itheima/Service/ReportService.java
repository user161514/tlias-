package com.itheima.Service;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.emp;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption getEmpJobData();

    List<Map<String,Object>> getGender();
}
