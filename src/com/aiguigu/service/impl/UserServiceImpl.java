package com.aiguigu.service.impl;

import com.aiguigu.dao.UserDao;
import com.aiguigu.dao.impl.UserDaoImpl;
import com.aiguigu.pojo.User;
import com.aiguigu.service.UserService;

/**
 * @author dabort
 * @date 2021/7/30 - 16:24
 */
public class UserServiceImpl implements UserService {

    public UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null){
            //等于null，说明没查到，没查到表示可用
            return false;
        }
        return true;
    }
}
