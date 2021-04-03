package com.springboot.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wuhui
 * @Date 2018/11/20
 * @Description
 */
@ComponentScan
@Configuration
@MapperScan("com.springboot.data.dao")
public class DataConfiguration {
}
