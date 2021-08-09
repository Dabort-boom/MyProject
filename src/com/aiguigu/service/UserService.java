package com.aiguigu.service;

import com.aiguigu.pojo.User;

import javax.crypto.interfaces.PBEKey;

/**
 * @author dabort
 * @date 2021/7/30 - 16:15
 */
public interface UserService {


    /**
     * 注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return  如果返回null，登录失败，返回有值，登录成功
     */
    public User login(User user);

    /**
     * 查询用户是否可用
     * @param username
     * @return  返回true表示用户名以存在，返回false表示用户名可用
     */
    public boolean existsUsername(String username);


}
