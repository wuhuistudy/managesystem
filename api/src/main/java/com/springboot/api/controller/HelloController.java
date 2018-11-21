package com.springboot.api.controller;

import com.springboot.core.HelloService;
import com.springboot.domain.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wuhui
 * @Date 2018/11/21
 * @Description
 */
@RestController
public class HelloController
{
    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public List<UserRole> hello() {
        return helloService.sayHello();
    }
}
