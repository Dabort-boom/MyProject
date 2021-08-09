package com.aiguigu.test;

import com.aiguigu.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author dabort
 * @date 2021/7/30 - 11:50
 */
public class JdbcUtilsTest {

    @Test
    public void test(){
        for (int i = 0;i < 100; i++) {

            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);

        }
    }

}
