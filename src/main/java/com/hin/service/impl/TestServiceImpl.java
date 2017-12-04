package com.hin.service.impl;

import com.hin.service.TestService;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//@Service("testService")
public class TestServiceImpl<T> implements TestService {
    private Class<T> clazz;

    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 事务测试
     */
    public void insertTestTwoSql(){
        boolean flag = true;

        try {
            jdbcTemplate.execute("insert into t1(name) values('a1')");
            System.out.println("insert into t1(name) values('a1')");
            if(flag){
                throw new RuntimeException();
            }

            jdbcTemplate.execute("insert into t2(name) values('a2')");
            System.out.println("insert into t2(name) values('a2')");
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }
    }
}
