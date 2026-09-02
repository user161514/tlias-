package com.itheima.Service.serviceimpl;

import com.itheima.Service.EmpLogService;
import com.itheima.mapper.EmpLogMapper;
import com.itheima.pojo.EmpLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Properties;


@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(EmpLog empLog) {

        empLogMapper.insert(empLog);
    }
}