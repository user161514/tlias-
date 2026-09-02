package com.heima.springbootproject01;

import com.itheima.Dao;
import com.itheima.user;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootProject01ApplicationTests {
    @Autowired
    private Dao x;

    @Test
    public void y() {
            List<user> b = x.b(1,"555");
        System.out.println(b);


    }


}
