package com.aiguigu.web;

import com.aiguigu.pojo.User;
import com.aiguigu.service.UserService;
import com.aiguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dabort
 * @date 2021/7/30 - 16:45
 */
public class RegistServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2.检查  验证码是否正确====写死，要求验证码为：abcde
        if ("abcde".equalsIgnoreCase(code)){
            //正确
            //3.检查  用户名是否可用
            if (userService.existsUsername(username)){
                //不可用
                System.out.println("用户名["+username+"]已存在，不可用");
                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
            }else {
                //可用
                System.out.println("用户名可用["+username+"]");
                //调用Service保存到数据库
                userService.registUser(new User(null,username,password,email));
                //跳转到注册成功页面 regist_success.html
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
            }

        }else {
            //不正确
            //跳回注册页面
            System.out.println("验证码错误["+code+"]");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
