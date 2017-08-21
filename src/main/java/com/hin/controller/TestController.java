package com.hin.controller;

import com.hin.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 事务测试
 */

@Controller
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public void test(){
        testService.insertTestTwoSql();
    }
}
