package com.itheima.Service.serviceimpl;

import com.itheima.Service.LoginService;
import com.itheima.mapper.empMapper;
import com.itheima.pojo.Logininfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {

    /**
     * @param m
     * @retur*/

    @Autowired
    private empMapper k;
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Logininfo Login(Logininfo empList) {
       Logininfo login = k.Login(empList);
        return login;
    }
}
