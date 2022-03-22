package com.belong.smart;


import com.belong.smart.utils.JwtUtils;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    public void test01() {
        System.out.println(JwtUtils.SECRET_KEY);
        System.out.println(JwtUtils.ExpiresIn);
    }
}
