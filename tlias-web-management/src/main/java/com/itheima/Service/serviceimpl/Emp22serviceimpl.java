package com.itheima.Service.serviceimpl;

import com.itheima.Service.Emp22service;
import com.itheima.mapper.Emp22Mapper;
import com.itheima.pojo.Emp22;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Emp22serviceimpl implements Emp22service {
    /**
     * @return
     */
    @Autowired
    private Emp22Mapper d;
    @Override
    public List<Emp22> select(Emp22 emplist) {
        List<Emp22> select = d.select(emplist);
        return select;
    }
}
