package com.springboot.api.controller;

import com.springboot.core.HelloService;
import com.springboot.domain.entity.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    /**
     * 添加日志
     **/
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public List<UserRole> hello() {
        // 日志级别
        LOG.debug("######  打印日志  #######");
        return helloService.sayHello();
    }
}
