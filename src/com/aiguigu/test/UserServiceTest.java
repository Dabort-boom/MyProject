package com.aiguigu.test;

import com.aiguigu.pojo.User;
import com.aiguigu.service.UserService;
import com.aiguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author dabort
 * @date 2021/7/30 - 16:29
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {

        userService.registUser(new User(null,"bbj168","666666","bbj168@qq.com"));
        userService.registUser(new User(null,"abc168","666666","abc 168@qq.com"));

    }

    @Test
    public void login() {

        System.out.println(userService.login(new User(null,"wzg168","123456",null)));

    }

    @Test
    public void existsUsername() {

        if (userService.existsUsername("wzg168")){
            System.out.println("用户名已经存在");
        }else {
            System.out.println("用户名可用");
        }

    }
}