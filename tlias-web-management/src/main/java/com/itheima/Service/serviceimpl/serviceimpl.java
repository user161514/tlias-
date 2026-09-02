package com.itheima.Service.serviceimpl;

import com.itheima.Service.service;
import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class serviceimpl implements service {

    @Autowired
    private DeptMapper dao;

    public void getDate(Integer id) {
        dao.selectAll(id);
    }

    @Override
    public void insert(user m) {
        dao.insertDept(m);
    }


    @Override
    public List<user> selectById(Integer id) {
        return dao.selectById(id);
    }
    public void update(user k){
        LocalDateTime now = LocalDateTime.now();
        k.setUpdatetime(now.toString());
        dao.update(k);
    }



}
