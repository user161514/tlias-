package com.itheima.Service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.Service.Emp22service;
import com.itheima.mapper.Emp22Mapper;
import com.itheima.pojo.Emp22;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.page;
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
    public List<Emp22> select(Integer id) {
        List<Emp22> select = d.select(id);
        return select;
    }

    /**
     * @param name
     */
    @Override
    public void emp22Add(String name) {
        d.insert(name);

    }

    /**
     * @return
     */
    @Override
    public List<Emp22> select1() {
       return d.select1();
    }

    @Override
    public void update(String name, Integer id){
        d.update1(name,id);
    }


    @Override
    public void delete(Integer id) {
        d.delete1(id);
    }

    /**
     * @param 员工查询
     * @return
     */
    @Override
    public List<Emp22> selectemp(Emp22 dj) {
       return  d.query(dj);
    }

    @Override
    public PageResult selectlimit(page dj) {
        PageHelper.startPage(dj.getCurrentPage4(), dj.getPageSize4());
        Emp22 emp = new Emp22(dj.getGender(),dj.getEnd(),dj.getBegin(),dj.getName());
        List<Emp22> query = d.query(emp);
        Page<Emp22> query1 = (Page<Emp22>) query;
        PageResult<Emp22> emp22PageResult = new PageResult<>(query1.getTotal(), query1.getResult());
        return emp22PageResult;
    }


}
