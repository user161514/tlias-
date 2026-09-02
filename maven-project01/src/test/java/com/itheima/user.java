package com.itheima;

import com.itheima.test.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
@DisplayName("用户测试")
public class user {
    private UserService m;
    @BeforeEach
    void setUp() {
        m = new UserService();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "100000200010011011",   // 第1组：18位身份证
            "100000200010011031",    // 第2组：17位身份证（异常）
            "100000200010011051"     // 第3组：18位身份证
    })
    @DisplayName("测试获取年龄")
    void testGetAge(String idCard) {
                  // ✅ 正确
        int age = m.getAge(idCard);
        Assertions.assertEquals(22,age);
    }
}
