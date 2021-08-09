package com.aiguigu.test;

import com.aiguigu.dao.UserDao;
import com.aiguigu.dao.impl.UserDaoImpl;
import com.aiguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author dabort
 * @date 2021/7/30 - 15:47
 */
public class UserDaoTest {

    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在");
        }

    }

    @Test
    public void queryUserByUsernameAndPassword() {

        if (userDao.queryUserByUsernameAndPassword("admin","admin") == null){
            System.out.println("用户名或密码错误，登录失败");
        }else{
            System.out.println("登录成功");
        }

    }

    @Test
    public void saveUser() {

        System.out.println(userDao.saveUser(new User(null,"wzg168","123456","wzg168@qq.com")));

    }
}