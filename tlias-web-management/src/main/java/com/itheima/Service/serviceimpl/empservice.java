package com.itheima.Service.serviceimpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.Service.Empservice;
import com.itheima.mapper.empMapper;
import com.itheima.pojo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.itheima.mapper.emp_exprMapper;

@Service
@Slf4j
public class empservice implements Empservice {
    @Autowired
    private emp_exprMapper kk;
    @Autowired
    private empMapper d;
    @Autowired
    private EmpLogServiceImpl mm;



    public PageResult<emp> Limit(emp1 k) {
        PageHelper.startPage(k.getPage(), k.getPageSize());
        List<emp> limit = d.Limit(k);
        Page<emp> e = (Page<emp>) limit;
        PageResult<emp> empPageResult = new PageResult<>(e.getTotal(), e.getResult());
        return empPageResult;
    }
    @Transactional
    @Override
    public void save(emp k) {
//        1.保存员工基本信息
        try {
            k.setCreateTime(LocalDateTime.now());
            d.save(k);
//        2.保存员工的工作经历信息
            List<emp_expr> e = k.getExprList();
            if (!CollectionUtils.isEmpty(e)) {
                e.forEach(a->a.setEmpId(k.getId()));
                log.info("exprList内容：{}", k.getExprList());
                kk.saveBatch(e);
            }
        } finally {
            mm.insertLog(new EmpLog(null,LocalDateTime.now(),"新增员工"+k));
        }
        //记录操作日志

    }
   @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {
        d.delete(ids);
        kk.delete(ids);
    }
    @Override
    public List<emp> select(Integer id){
        List<emp>select = d.select(id);
        return select;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(emp k) {
        k.setCreateTime(LocalDateTime.now());
        d.updateById(k);
        List<Integer> list = Arrays.asList(k.getId());
        kk.delete(list);
        List<emp_expr> exprList = k.getExprList();
        if(!CollectionUtils.isEmpty(exprList))//我个人感觉这一步判空多余了
        {
            kk.saveBatch(exprList);
        }
    }


}
