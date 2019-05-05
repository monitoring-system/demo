package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

@Component
public class Test {

    @Resource
    UserMapper userMapper;

    @Resource
    private DataSource dataSource;

    @PostConstruct
    public void test() throws Exception {
        createTable();
        // select name, age from test
        List<User> us = userMapper.getAll();
        System.out.println(us.size());
        for (User u : us) {
            System.out.printf("%s----->%d\n", u.getName(), u.getAge());
        }
    }

    private void createTable() throws Exception {
        Connection conn = dataSource.getConnection();
        Statement s = conn.createStatement();
        s.execute("DROP TABLE IF EXISTS test");
        s.close();
        s = conn.createStatement();
        s.execute("CREATE TABLE TEST(NAME VARCHAR(20), AGE INT)");
        s.close();
        s = conn.createStatement();
        s.execute("INSERT INTO TEST(NAME, AGE) VALUES (\"test\", 1)");
        s.close();
    }

}
